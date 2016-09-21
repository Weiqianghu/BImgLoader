package com.huweiqiang.butil.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/6.
 */
public class BLoadUtil {
    public static String hashKeyFromUrl(String url) {
        String cacheyKey = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(url.getBytes());
            cacheyKey = bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return cacheyKey;
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }


    public static int calculateReqHeight(ImageView imageView) {
        int height = imageView.getHeight();
        if (height <= 0) {
            View parent = (View) imageView.getParent();
            if (parent == null) {
                getScreenHeight(imageView.getContext());
            } else {
                calculateReqHeight(parent);
            }
        }
        return height;
    }

    public static int calculateReqHeight(View view) {
        int height = view.getHeight();
        if (height <= 0) {
            View parent = (View) view.getParent();
            if (parent == null) {
                getScreenHeight(view.getContext());
            } else {
                calculateReqHeight(parent);
            }
        }
        return height;
    }

    public static int calculateReqWidth(View view) {
        int width = view.getWidth();
        if (width <= 0) {
            View parent = (View) view.getParent();
            if (parent == null) {
                getScreenWidth(view.getContext());
            } else {
                calculateReqWidth(parent);
            }
        }
        return width;
    }

    public static int calculateReqWidth(ImageView imageView) {
        int width = imageView.getWidth();
        if (width <= 0) {
            View parent = (View) imageView.getParent();
            if (parent == null) {
                getScreenWidth(imageView.getContext());
            } else {
                calculateReqWidth(parent);
            }
        }
        return width;
    }

    public static int getScreenHeight(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }
}
