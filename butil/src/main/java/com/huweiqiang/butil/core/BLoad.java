package com.huweiqiang.butil.core;

import android.content.Context;
import android.widget.ImageView;

import com.huweiqiang.butil.config.LoadConfig;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public final class BLoad {
    static Context mContext;

    private LoadConfig mLoadConfig;

    public void setLoadConfig(LoadConfig loadConfig) {
        mLoadConfig = loadConfig;
    }

    BLoad() {
    }

    public static BLoadBuilder with(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        mContext = context;
        return new BLoadBuilder();
    }


    void displayImg(final int resId, final ImageView imageView) {
        DisplayImg.getInstance().displayImg(resId, imageView);
    }

    void displayImg(final String url, final ImageView imageView) {
        displayImg(mLoadConfig.mDefaultImgResId, imageView);
        DisplayImg.getInstance().displayImg(url, imageView);
    }
}
