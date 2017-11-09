package com.example.i.AndroidDemos;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.i.AndroidDemos.service.GithubService;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

/***
 * Created by I on 2017/8/24.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    public static Context context;//全局的context (3dpager1)

    public static final String LOGIN_STATE = "LOGIN_STATE";
    public static final String IS_LOGIN_SUCCESS = "IS_LOGIN_SUCCESS";
    public static final String IS_DRAWER_OPEN = "IS_DRAWER_OPEN";

    private GithubService githubService;
    private Picasso picasso;

    private RefWatcher refWatcher;

    public static Context getContext() {
        return context;////全局的context (2)
    }

    public static MyApplication getMyApplication(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();////全局的context (3)
        Timber.plant(new Timber.DebugTree());



        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);
    }
}
