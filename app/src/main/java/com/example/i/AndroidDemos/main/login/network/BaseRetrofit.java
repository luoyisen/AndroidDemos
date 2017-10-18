package com.example.i.AndroidDemos.main.login.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 * Created by I on 2017/9/24.
 */

public abstract class BaseRetrofit {
    public Retrofit build() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(getBaseUrl())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return enrichBuilder(builder).build();
    }

    protected Retrofit.Builder enrichBuilder(Retrofit.Builder builder) {
        return builder;
    }

    protected OkHttpClient getOkHttpClient(){
        return new BaseOkHttpClient().build();
    }

    protected abstract String getBaseUrl();
}

