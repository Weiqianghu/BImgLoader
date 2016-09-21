package com.huweiqiang.butil.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.huweiqiang.butil.util.BLoadUtil;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public class MemoryCache implements Cache<String, Bitmap> {
    private LruCache<String, Bitmap> mMemoryCache;

    private MemoryCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    private static MemoryCache sMemoryCache;

    public static MemoryCache getInstance() {
        if (sMemoryCache == null) {
            synchronized (MemoryCache.class) {
                if (sMemoryCache == null) {
                    sMemoryCache = new MemoryCache();
                }
            }
        }
        return sMemoryCache;
    }


    @Override
    public void put(String s, Bitmap bitmap) {
        String key = BLoadUtil.hashKeyFromUrl(s);
        mMemoryCache.put(key, bitmap);
    }

    @Override
    public Bitmap get(String s) {
        String key = BLoadUtil.hashKeyFromUrl(s);
        return mMemoryCache.get(key);
    }
}
