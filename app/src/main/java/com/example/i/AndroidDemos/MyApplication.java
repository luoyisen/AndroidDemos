package com.example.i.AndroidDemos;

import android.app.Application;
import android.content.Context;

import com.example.i.AndroidDemos.dagger2.ComponentHolder;
import com.example.i.AndroidDemos.dagger2.component.AppComponent;
import com.example.i.AndroidDemos.dagger2.component.DaggerAppComponent;
import com.example.i.AndroidDemos.dagger2.component.DaggerLoginComponent;
import com.example.i.AndroidDemos.dagger2.module.ContextModule;
import com.example.i.AndroidDemos.service.GithubService;
import com.example.i.AndroidDemos.util.SharedPreferencesUtil;
import com.example.i.AndroidDemos.util.TypefaceHelper;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

/***
 * Created by I on 2017/8/24.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private RefWatcher refWatcher;

    public static Context context;//全局的context (3dpager1)
    public static final String LOGIN_STATE = "LOGIN_STATE";
    public static final String IS_LOGIN_SUCCESS = "IS_LOGIN_SUCCESS";

    public static final String IS_DRAWER_OPEN = "IS_DRAWER_OPEN";
    private GithubService githubService;

    private Picasso picasso;

    public static Context getContext() {
        return context;////全局的context (2)
    }

    public static MyApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        initComponents();
        Logger.addLogAdapter(new AndroidLogAdapter());
        instance = this;
        context = getApplicationContext();////全局的context (3)
        TypefaceHelper.generateTypeface(this);
        Timber.plant(new Timber.DebugTree());
        refWatcher = LeakCanary.install(this);
        SharedPreferencesUtil.initSP(getApplicationContext(), getPackageName() + "_prefes", MODE_PRIVATE);
    }

    protected void initComponents() {
        AppComponent appComponent = DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
        ComponentHolder.setContext(this);
        ComponentHolder.setAppComponent(appComponent);
//        ComponentHolder.setExploreComponent(DaggerExploreComponent.builder().appComponent(appComponent).build());
//        ComponentHolder.setHomePageComponent(DaggerHomePageComponent.builder().appComponent(appComponent).build());
//        ComponentHolder.setListItemComponent(DaggerListItemComponent.builder().appComponent(appComponent).build());
        ComponentHolder.setLoginComponent(DaggerLoginComponent.builder().appComponent(appComponent).build());
//        ComponentHolder.setNewsComponent(DaggerNewsComponent.builder().appComponent(appComponent).build());
//        ComponentHolder.setRepoPageComponent(DaggerRepoPageComponent.builder().appComponent(appComponent).build());
//        ComponentHolder.setSearchComponent(DaggerSearchComponent.builder().appComponent(appComponent).build());
    }

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }
}
