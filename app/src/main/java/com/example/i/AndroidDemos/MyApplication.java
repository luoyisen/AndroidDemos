package com.example.i.AndroidDemos;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by I on 2017/8/24.
 */

public class MyApplication extends Application {
    private boolean isloginSuccessful;

    public boolean getLoginSuccessful() {
        return isloginSuccessful;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        this.isloginSuccessful = loginSuccessful;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        isloginSuccessful = false;
    }
}
