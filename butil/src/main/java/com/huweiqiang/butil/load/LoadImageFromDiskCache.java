package com.huweiqiang.butil.load;

import com.huweiqiang.butil.core.LoadHandler;
import com.huweiqiang.butil.request.DownloadImgTask;
import com.huweiqiang.butil.request.LoadRequest;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/9.
 */
public class LoadImageFromDiskCache implements LoadImage {
    private static volatile LoadImageFromDiskCache sLoadImageFromDiskCache;

    private LoadImageFromDiskCache() {
    }

    public static LoadImageFromDiskCache getInstance() {
        if (sLoadImageFromDiskCache == null) {
            synchronized (LoadImageFromDiskCache.class) {
                if (sLoadImageFromDiskCache == null) {
                    sLoadImageFromDiskCache = new LoadImageFromDiskCache();
                }
            }
        }
        return sLoadImageFromDiskCache;
    }

    @Override
    public void loadImg(LoadRequest loadRequest) {
        new DownloadImgTask(loadRequest.mContext, loadRequest.mUrl, loadRequest.mImageView, LoadHandler.sHandler).submit();
    }

    @Override
    public void next(LoadRequest loadRequest) {

    }


}
