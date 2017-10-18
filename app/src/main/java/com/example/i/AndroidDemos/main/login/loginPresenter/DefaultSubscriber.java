package com.example.i.AndroidDemos.main.login.loginPresenter;

import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.util.Utils;

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
//        LogUtils.d("RxCompleted");
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
            onError(Utils.getString(R.string.error_time_out));
        } else if (e instanceof HttpException) {
            onError(Utils.getString(R.string.error_network));
            HttpException httpException = (HttpException) e;
            if (httpException.response() != null && httpException.response().errorBody() != null) {
                try {
                    String bodyStr = httpException.response().errorBody().string();
                } catch (IOException e1) {
                    Toast.makeText(MyApplication.getContext(), e1.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            onError("");
        }
    }

    protected void onError(String errorStr) {
        Toast.makeText(MyApplication.getContext(), errorStr, Toast.LENGTH_SHORT).show();
    }

}

