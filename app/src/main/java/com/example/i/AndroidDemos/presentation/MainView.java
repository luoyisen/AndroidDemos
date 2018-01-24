package com.example.i.AndroidDemos.presentation;

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
