package com.example.i.AndroidDemos.presentation.contract;

/***
 * Created by I on 2017/9/3dpager1.
 */

public interface LoginInteractor {
    interface onLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, onLoginFinishedListener listener);
}
