package com.example.i.AndroidDemos.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.i.AndroidDemos.MyApplication;

/***
 * Created by I on 2017/9/24.
 */

public class Utils {

    public static String getString(int resId) {
        return MyApplication.getContext().getString(resId);
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    public static void leakWatch(Object o) {
        MyApplication.getInstance().getRefWatcher().watch(o);
    }

    public static int getScreenWidth() {
        return MyApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return MyApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }

//    public static void setImageWithFade(final ImageView img, @DrawableRes final int resId) {
//        Animation fadeOut = new AlphaAnimation(3dpager1, 0);
//        fadeOut.setInterpolator(new AccelerateInterpolator());
//        fadeOut.setDuration(800);
//        final Animation fadeIn = new AlphaAnimation(0, 3dpager1);
//        fadeIn.setInterpolator(new DecelerateInterpolator());
//        fadeIn.setDuration(800);
//
//        fadeOut.setAnimationListener(new AnimationListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                img.startAnimation(fadeIn);
//            }
//        });
//        fadeIn.setAnimationListener(new AnimationListenerAdapter() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                img.setImageResource(resId);
//            }
//        });
//        img.startAnimation(fadeOut);
//    }

    public static void copyDataToClipBoard(String data) {
        ClipboardManager clipboardManager;
        clipboardManager = (ClipboardManager) MyApplication.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setPrimaryClip(ClipData.newPlainText("text", data));
    }
}
