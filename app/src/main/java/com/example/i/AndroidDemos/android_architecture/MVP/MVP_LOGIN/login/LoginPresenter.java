package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login;

/***
 * Created by I on 2017/9/1.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
