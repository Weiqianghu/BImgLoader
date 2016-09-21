package com.huweiqiang.butil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;

import com.huweiqiang.butil.LoaderResult;
import com.huweiqiang.butil.cache.DiskCache;
import com.huweiqiang.butil.cache.MemoryCache;
import com.huweiqiang.butil.util.BLoadUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public class DownloadImgTask implements Runnable {
    public static final int MESSAGE_POST_RESULT = 0X100;

    private String mUrl;
    private Handler mHandler;
    private ImageView mImageView;
    private Context mContext;


    public DownloadImgTask(Context context, String url, ImageView imageView, Handler handler) {
        this.mUrl = url;
        this.mHandler = handler;
        this.mImageView = imageView;
        this.mContext = context;
    }

    @Override
    public void run() {
        DiskCache.getInstance(mContext).put(mUrl, null);
        Bitmap bitmap = DiskCache.getInstance(mContext).get(mUrl, BLoadUtil.calculateReqHeight(mImageView), BLoadUtil.calculateReqWidth(mImageView));
        if (bitmap != null) {
            MemoryCache.getInstance().put(mUrl, bitmap);
            LoaderResult result = new LoaderResult(mImageView, mUrl, bitmap);
            mHandler.obtainMessage(MESSAGE_POST_RESULT, result).sendToTarget();
        } else {
            LoaderResult result = new LoaderResult(mImageView, mUrl, null);
            mHandler.obtainMessage(MESSAGE_POST_RESULT, result).sendToTarget();
        }
    }

    public void submit() {
        sThreadPoolExecutor.submit(this);
    }


    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE_SECONDS = 30;

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "DownloadImgTask #" + mCount.getAndIncrement());
        }
    };

    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(128);

    static ThreadPoolExecutor sThreadPoolExecutor = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS,
            sPoolWorkQueue, sThreadFactory);
}
