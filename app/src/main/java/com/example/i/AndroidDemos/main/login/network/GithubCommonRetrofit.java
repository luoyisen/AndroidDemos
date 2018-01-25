package com.example.i.AndroidDemos.main.login.network;

import com.example.i.AndroidDemos.constant.Constant;

import okhttp3.OkHttpClient;

/***
 * Created by I on 2017/9/24.
 */

public class GithubCommonRetrofit extends BaseRetrofit {
    private GithubOkHttpClient client;

    public GithubCommonRetrofit(GithubOkHttpClient client) {
        this.client = client;
    }

    @Override
    protected String getBaseUrl() {
        return Constant.URL_GITHUB;
    }

    @Override
    protected OkHttpClient getOkHttpClient() {
        return client.build();
    }
}
