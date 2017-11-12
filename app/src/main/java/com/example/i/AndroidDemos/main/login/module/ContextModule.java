package com.example.i.AndroidDemos.main.login.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/***
 * Created by I on 2017/11/12.
 */
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }
}
