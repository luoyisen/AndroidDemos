package com.example.i.AndroidDemos.noteandtools.tools;

import android.graphics.drawable.Drawable;

/***
 * Created by I on 2017/8/27.
 */

public class AppInfo {

    private String appName;
    private Drawable appIcon;

    public String getAppName() {
        return appName;
    }

    void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    @Override
    public String toString() {
        return appName;
    }
}
