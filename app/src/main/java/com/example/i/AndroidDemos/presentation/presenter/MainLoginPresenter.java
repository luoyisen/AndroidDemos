package com.example.i.AndroidDemos.presentation.presenter;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BasePresenter;
import com.example.i.AndroidDemos.constant.bean.UserDataSource;
import com.example.i.AndroidDemos.main.login.loginPresenter.DefaultSubscriber;
import com.example.i.AndroidDemos.presentation.contract.MainLoginContract;
import com.example.i.AndroidDemos.util.RxJavaUtils;
import com.example.i.AndroidDemos.util.Utils;
import com.orhanobut.logger.Logger;

import rx.functions.Action1;

/***
 * Created by I on 2017/9/24.
 */

public class MainLoginPresenter extends BasePresenter<MainLoginContract.View> implements MainLoginContract.Presenter {
    private UserDataSource mDataSource;

    public MainLoginPresenter(UserDataSource dataSource) {
        mDataSource = dataSource;
    }

    @Override
    public void login(String username, String password) {
        if (!checkNetwork())
            return;
        addSubscription(mDataSource.login(username, password)
                .compose(RxJavaUtils.<Boolean>setLoadingListener(getView()))
                .subscribe(new DefaultSubscriber<Boolean>() {
                    @Override
                    public void onNext(Boolean success) {
                        Logger.e(success + "");
                        if (success)
                            getView().showOnSuccess();
                        else getView().showOnError(Utils.getString(R.string.error_login));
                    }

                    @Override
                    protected void onError(String errorStr) {
                        getView().showOnError(Utils.getString(R.string.error_login) + "Check your name and password.");
                    }
                }));
    }

    @Override
    public void signOut() {
        mDataSource.signOut()
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean success) {
                        if (success)
                            getView().showOnSuccess();
                        else getView().showOnError(Utils.getString(R.string.error_sign_out));
                    }
                });
    }

    @Override
    public String getLoginUserName() {
        return mDataSource.getLoginUserName();
    }

}