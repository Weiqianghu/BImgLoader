package com.huweiqiang.butil.load;

import android.graphics.Bitmap;

import com.huweiqiang.butil.cache.DiskCache;
import com.huweiqiang.butil.cache.MemoryCache;
import com.huweiqiang.butil.request.LoadRequest;
import com.huweiqiang.butil.util.BLoadUtil;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/9.
 */
public class LoadImageFromMemoryCache implements LoadImage {
    private static volatile LoadImageFromMemoryCache sLoadImageFromMemoryCache;

    private LoadImageFromMemoryCache() {
    }

    public static LoadImageFromMemoryCache getInstance() {
        if (sLoadImageFromMemoryCache == null) {
            synchronized (LoadImageFromMemoryCache.class) {
                if (sLoadImageFromMemoryCache == null) {
                    sLoadImageFromMemoryCache = new LoadImageFromMemoryCache();
                }
            }
        }
        return sLoadImageFromMemoryCache;
    }

    @Override
    public void loadImg(LoadRequest loadRequest) {
        Bitmap bitmap = MemoryCache.getInstance().get(loadRequest.mUrl);
        if (bitmap == null) {
            bitmap = DiskCache.getInstance(loadRequest.mContext).get(loadRequest.mUrl, BLoadUtil.calculateReqHeight(loadRequest.mImageView), BLoadUtil.calculateReqWidth(loadRequest.mImageView));
        }
        if (bitmap != null) {
            loadRequest.mImageView.setImageBitmap(bitmap);
        } else {
            next(loadRequest);
        }
    }

    @Override
    public void next(LoadRequest loadRequest) {
        LoadImageFromDiskCache.getInstance().loadImg(loadRequest);
    }
}
