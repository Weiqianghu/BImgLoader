package com.huweiqiang.butil.load;

import android.content.res.Resources;
import android.graphics.Bitmap;

import com.huweiqiang.butil.DecodeBitmap;
import com.huweiqiang.butil.cache.MemoryCache;
import com.huweiqiang.butil.request.LoadRequest;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/9.
 */
public class LoadImageFromResource implements LoadImage {
    private static volatile LoadImageFromResource sLoadImageFromResource;

    private LoadImageFromResource() {
    }

    public static LoadImageFromResource getInstance() {
        if (sLoadImageFromResource == null) {
            synchronized (LoadImageFromResource.class) {
                if (sLoadImageFromResource == null) {
                    sLoadImageFromResource = new LoadImageFromResource();
                }
            }
        }
        return sLoadImageFromResource;
    }

    @Override
    public void loadImg(LoadRequest loadRequest) {
        DecodeBitmap decodeBitmap = DecodeBitmap.getInstance();
        Resources resources = loadRequest.mContext.getResources();
        int height = loadRequest.mImageView.getHeight();
        int width = loadRequest.mImageView.getWidth();

        Bitmap bitmap = MemoryCache.getInstance().get(String.valueOf(loadRequest.mResId));
        if (bitmap == null) {
            bitmap = decodeBitmap.decodeBitmap(resources, loadRequest.mResId, height, width);
            if (bitmap != null) {
                MemoryCache.getInstance().put(String.valueOf(loadRequest.mResId), bitmap);
            }
        }
        if (bitmap != null) {
            loadRequest.mImageView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void next(LoadRequest loadRequest) {

    }
}
