package com.huweiqiang.butil.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.huweiqiang.butil.DecodeBitmap;
import com.huweiqiang.butil.request.ImageDownload;
import com.huweiqiang.butil.util.BLoadUtil;
import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public class DiskCache implements Cache<String, Bitmap> {
    private static final int DISK_CACHE_SIZE = 1024 * 1024 * 100;
    private static final int DISK_CACHE_INDEX = 0;

    private DiskLruCache mDiskLruCache;


    private DiskCache(Context context) {
        File diskCacheDir = getDIskCacheDir(context);
        if (!diskCacheDir.exists()) {
            diskCacheDir.mkdirs();
        }
        try {
            mDiskLruCache = DiskLruCache.open(diskCacheDir, 1, 1, DISK_CACHE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static DiskCache sDiskCache;

    public static DiskCache getInstance(Context context) {
        if (sDiskCache == null) {
            synchronized (DiskCache.class) {
                if (sDiskCache == null) {
                    sDiskCache = new DiskCache(context);
                }
            }
        }
        return sDiskCache;
    }


    @Override
    public void put(String url, Bitmap bitmap) {
        String key = BLoadUtil.hashKeyFromUrl(url);
        try {
            DiskLruCache.Editor editor = mDiskLruCache.edit(key);
            if (editor != null) {
                OutputStream outputStream = editor.newOutputStream(DISK_CACHE_INDEX);
                if (ImageDownload.getInstance().downloadUrlToStream(url, outputStream)) {
                    editor.commit();
                } else {
                    editor.abort();
                }
            }
            mDiskLruCache.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = null;
        String key = BLoadUtil.hashKeyFromUrl(url);
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
            if (snapshot != null) {
                FileInputStream fileInputStream = (FileInputStream) snapshot.getInputStream(DISK_CACHE_INDEX);
                FileDescriptor fileDescriptor = fileInputStream.getFD();
                bitmap = DecodeBitmap.getInstance().decodeBitmap(fileDescriptor, 0, 0);
            }
            if (bitmap != null) {
                MemoryCache.getInstance().put(url, bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    public Bitmap get(String url, int reqHeight, int reqWidth) {
        Bitmap bitmap = null;
        String key = BLoadUtil.hashKeyFromUrl(url);
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
            if (snapshot != null) {
                FileInputStream fileInputStream = (FileInputStream) snapshot.getInputStream(DISK_CACHE_INDEX);
                FileDescriptor fileDescriptor = fileInputStream.getFD();
                bitmap = DecodeBitmap.getInstance().decodeBitmap(fileDescriptor, reqHeight, reqWidth);
            }
            if (bitmap != null) {
                MemoryCache.getInstance().put(url, bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    private File getDIskCacheDir(Context context) {
        boolean externalStorageAvailable = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        final String cachePath;
        if (externalStorageAvailable) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }

        return new File(cachePath + File.separator + "bitmap");
    }


}
