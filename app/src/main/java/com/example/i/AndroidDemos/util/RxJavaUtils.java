package com.example.i.AndroidDemos.util;

import com.example.i.AndroidDemos.base.BaseView;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/***
 * Created by I on 2017/9/24.
 */

public class RxJavaUtils {
    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable.Transformer<T, T> setLoadingListener(final BaseView view) {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        view.showOnLoading();
                    }
                });
            }
        };
    }

    public static Observable.Transformer<Response<ResponseBody>, Boolean> checkIfSuccessCode() {
        return new Observable.Transformer<Response<ResponseBody>, Boolean>() {
            @Override
            public Observable<Boolean> call(Observable<Response<ResponseBody>> observable) {
                return observable.map(new Func1<Response<ResponseBody>, Boolean>() {
                    @Override
                    public Boolean call(Response<ResponseBody> response) {
                        return response != null && response.code() == 204;
                    }
                });
            }
        };
    }
}
