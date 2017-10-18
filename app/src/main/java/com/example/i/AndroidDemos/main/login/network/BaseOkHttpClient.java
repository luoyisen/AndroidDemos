package com.example.i.AndroidDemos.main.login.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/***
 * Created by I on 2017/9/24.
 */

class BaseOkHttpClient {
    public OkHttpClient build() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        return enrichBuilder(builder).build();
    }

    protected OkHttpClient.Builder enrichBuilder(OkHttpClient.Builder builder) {
        return builder;
    }

}
