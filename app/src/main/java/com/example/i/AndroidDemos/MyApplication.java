package com.example.i.AndroidDemos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/***
 * Created by I on 2017/8/24.
 */

public class MyApplication extends Application {
    public static Context context;//全局的context (1)
    public static SharedPreferences sharedPreferences;
    public static final String LOGIN_STATE = "LOGIN_STATE";
    public static final String IS_LOGIN_SUCCESS = "IS_LOGIN_SUCCESS";

    public static Context getContext() {
        return context;////全局的context (2)
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();////全局的context (3)
        sharedPreferences = getSharedPreferences(LOGIN_STATE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_LOGIN_SUCCESS, false);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);
    }
}
