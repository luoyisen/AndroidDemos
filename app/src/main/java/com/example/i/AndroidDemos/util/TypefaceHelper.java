package com.example.i.AndroidDemos.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by HHX on 2018/2/7.
 */

public class TypefaceHelper {
    private static Typeface typeface;

    public static void generateTypeface(Context context) {
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Arial_Rounded_MT_Bold.ttf");
    }

    public static void applyTypeface(TextView textView) {
        textView.setTypeface(typeface);
    }

    public static Typeface getTypeface() {
        return typeface;
    }
}
