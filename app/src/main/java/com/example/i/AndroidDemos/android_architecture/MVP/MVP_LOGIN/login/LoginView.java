package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login;

/**
 * Created by I on 2017/9/1.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
