package com.huweiqiang.butil;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileDescriptor;
import java.io.InputStream;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public class DecodeBitmap {
    private static DecodeBitmap sDecodeBitmap;

    private DecodeBitmap() {
    }

    public static DecodeBitmap getInstance() {
        if (sDecodeBitmap == null) {
            synchronized (DecodeBitmap.class) {
                if (sDecodeBitmap == null) {
                    sDecodeBitmap = new DecodeBitmap();
                }
            }
        }
        return sDecodeBitmap;
    }

    public int calculateInSampleSize(int oldHeight, int oldWidth, int reqHeight, int reqWidth) {
        if (reqHeight == 0 || reqWidth == 0) {
            return 1;
        }

        int inSampleSize = 1;
        if (oldHeight > reqHeight || oldWidth > reqWidth) {
            int halfHeight = oldHeight / 2;
            int halfWidth = oldWidth / 2;
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public Bitmap decodeBitmap(InputStream inputStream, int reqHeight, int reqWidth) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);

        options.inSampleSize = this.calculateInSampleSize(options.outHeight, options.outWidth, reqHeight, reqWidth);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public Bitmap decodeBitmap(Resources resources, int resId, int reqHeight, int reqWidth) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);

        options.inSampleSize = this.calculateInSampleSize(options.outHeight, options.outWidth, reqHeight, reqWidth);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(resources, resId, options);
    }

    public Bitmap decodeBitmap(FileDescriptor fileDescriptor, int reqHeight, int reqWidth) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);

        options.inSampleSize = this.calculateInSampleSize(options.outHeight, options.outWidth, reqHeight, reqWidth);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }


}
