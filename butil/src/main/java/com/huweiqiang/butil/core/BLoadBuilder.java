package com.huweiqiang.butil.core;

import android.widget.ImageView;

import com.huweiqiang.butil.config.LoadConfig;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/9.
 */
public class BLoadBuilder {
    private BLoad mBLoad = new BLoad();
    private LoadConfig mLoadConfig = new LoadConfig();

    public BLoadBuilder placeHolder(int resId) {
        mLoadConfig.mDefaultImgResId = resId;
        return this;
    }

    public BLoadBuilder load(String uri) {
        mLoadConfig.mUrl = uri;
        return this;
    }

    public BLoadBuilder error(int resId) {
        mLoadConfig.mErrorImgResId = resId;
        return this;
    }

    public void into(ImageView imageView) {
        mBLoad.setLoadConfig(mLoadConfig);

        if (mLoadConfig.mUrl != null) {
            mBLoad.displayImg(mLoadConfig.mUrl, imageView);
        } else if (mLoadConfig.mResId != -1) {
            mBLoad.displayImg(mLoadConfig.mResId, imageView);
        }
    }
}
