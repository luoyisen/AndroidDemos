package com.example.i.AndroidDemos.presentation.contract;

import com.example.i.AndroidDemos.base.BaseView;
import com.example.i.AndroidDemos.presentation.presenter.MvpPresenter;

/***
 * Created by I on 2017/9/24.
 */

public interface MainLoginContract {

    interface View extends BaseView {
    }

    interface Presenter extends MvpPresenter<View> {
        void login(String username, String password);

        void signOut();

        String getLoginUserName();
    }
}
