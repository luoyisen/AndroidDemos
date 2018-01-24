package com.example.i.AndroidDemos.presentation;

/***
 * Created by I on 2017/9/3dpager1.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void showLoginSuccessActivity();
}
