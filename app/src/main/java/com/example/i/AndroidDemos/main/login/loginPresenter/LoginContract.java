package com.example.i.AndroidDemos.main.login.loginPresenter;

import com.example.i.AndroidDemos.main.base.BaseView;
import com.example.i.AndroidDemos.main.base.MvpPresenter;

/***
 * Created by I on 2017/9/24.
 */

public interface LoginContract {

    interface View extends BaseView {
    }

    interface Presenter extends MvpPresenter<View> {
        void login(String username, String password);

        void signOut();

        String getLoginUserName();
    }
}
