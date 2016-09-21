package com.huweiqiang.butil.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;

import com.huweiqiang.butil.LoaderResult;
import com.huweiqiang.butil.cache.MemoryCache;
import com.huweiqiang.butil.config.LoadConfig;
import com.huweiqiang.butil.request.DownloadImgTask;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/9.
 */
public class LoadHandler {
    public static Handler sHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == DownloadImgTask.MESSAGE_POST_RESULT) {
                LoaderResult result = (LoaderResult) msg.obj;
                ImageView imageView = result.mImageView;
                Bitmap bitmap = result.mBitmap;
                String url = result.mUrl;
                if (imageView.getTag() == result.mUrl && bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                    MemoryCache.getInstance().put(url, bitmap);
                } else if (bitmap == null && imageView.getTag() == result.mUrl) {
                    //DisplayImg.getInstance().displayImg(mLoadConfig.mErrorImgResId, imageView);
                }
            }
        }
    };

    private LoadConfig mLoadConfig;

    public void setLoadConfig(LoadConfig loadConfig) {
        mLoadConfig = loadConfig;
    }
}
