package com.example.i.AndroidDemos.presentation.presenter;

/***
 * Created by I on 2017/9/3dpager1.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
