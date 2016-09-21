package com.huweiqiang.butil.core;

import android.widget.ImageView;

import com.huweiqiang.butil.load.LoadImageFromMemoryCache;
import com.huweiqiang.butil.load.LoadImageFromResource;
import com.huweiqiang.butil.request.LoadRequest;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/21.
 */

public class DisplayImg {

    public static DisplayImg getInstance() {
        return DisplayImgHolder.sDisplayImg;
    }

    private static class DisplayImgHolder {
        private static DisplayImg sDisplayImg = new DisplayImg();
    }


    void displayImg(final int resId, final ImageView imageView) {
        imageView.post(new Runnable() {
            @Override
            public void run() {
                LoadRequest loadRequest = new LoadRequest();
                loadRequest.mContext = imageView.getContext();
                loadRequest.mImageView = imageView;
                loadRequest.mResId = resId;
                LoadImageFromResource.getInstance().loadImg(loadRequest);
            }
        });
    }

    void displayImg(final String url, final ImageView imageView) {
        imageView.post(new Runnable() {
            @Override
            public void run() {
                imageView.setTag(url);
                LoadRequest loadRequest = new LoadRequest();
                loadRequest.mContext = imageView.getContext();
                loadRequest.mImageView = imageView;
                loadRequest.mUrl = url;
                LoadImageFromMemoryCache.getInstance().loadImg(loadRequest);
            }
        });
    }
}
