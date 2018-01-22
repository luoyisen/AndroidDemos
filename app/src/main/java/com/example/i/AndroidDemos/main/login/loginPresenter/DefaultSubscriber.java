package com.example.i.AndroidDemos.main.login.loginPresenter;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.util.Utils;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/***
 * Created by I on 2017/9/24.
 */

public abstract class DefaultSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        Logger.d("RxCompleted");
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
            onError(Utils.getString(R.string.error_time_out));
        } else if (e instanceof HttpException) {
            onError(Utils.getString(R.string.error_network));
            HttpException httpException = (HttpException) e;
            Logger.e(String.valueOf(httpException.code()));
            Logger.e(httpException.message());
            if (httpException.response() != null && httpException.response().errorBody() != null) {
                try {
                    Logger.e(httpException.response().message());
                    String bodyStr = httpException.response().errorBody().string();
                    Logger.e(bodyStr);
                } catch (IOException e1) {
                    Logger.e(e1.getMessage());
                }
            }
        } else {
            onError("");
        }
    }

    protected void onError(String errorStr) {
        Logger.e(errorStr);
    }

}
