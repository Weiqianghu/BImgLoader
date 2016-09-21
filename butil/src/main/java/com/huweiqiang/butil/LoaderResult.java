package com.huweiqiang.butil;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public class LoaderResult {
    public ImageView mImageView;
    public String mUrl;
    public Bitmap mBitmap;

    public LoaderResult(ImageView imageView, String url, Bitmap bitmap) {
        mImageView = imageView;
        mUrl = url;
        this.mBitmap = bitmap;
    }
}
