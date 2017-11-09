package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login_success;

import java.util.List;

/**
 * Created by I on 2017/9/3dpager1.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);

    void showSnackBar(String information);
}
