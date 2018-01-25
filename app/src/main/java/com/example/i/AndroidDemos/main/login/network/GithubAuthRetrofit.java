package com.example.i.AndroidDemos.main.login.network;

import android.util.Base64;

import com.example.i.AndroidDemos.constant.Constant;
import com.example.i.AndroidDemos.util.StringUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/***
 * Created by I on 2017/9/24.
 */

public class GithubAuthRetrofit extends BaseRetrofit {
    private String userName;
    private String password;

    public void setUserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected String getBaseUrl() {
        return Constant.URL_GITHUB;
    }

    @Override
    protected OkHttpClient getOkHttpClient() {
        return new AuthOkHttpClient(userName, password).build();
    }

    public class AuthOkHttpClient extends BaseOkHttpClient {
        private String userName;
        private String password;

        public AuthOkHttpClient(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        @Override
        protected OkHttpClient.Builder enrichBuilder(OkHttpClient.Builder builder) {
            if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
                builder.addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        // https://developer.github.com/v3/auth/#basic-authentication
                        // https://developer.github.com/v3/oauth/#non-web-application-flow
                        String userCredentials = userName + ":" + password;

                        String basicAuth =
                                "Basic " + new String(Base64.encode(userCredentials.getBytes(), Base64.DEFAULT));

                        Request original = chain.request();

                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Authorization", basicAuth.trim());

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                });
            }
            return super.enrichBuilder(builder);
        }
    }
}

