package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login_success;

import java.util.List;

/**
 * Created by I on 2017/9/3dpager1.
 */

public interface FindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
}
