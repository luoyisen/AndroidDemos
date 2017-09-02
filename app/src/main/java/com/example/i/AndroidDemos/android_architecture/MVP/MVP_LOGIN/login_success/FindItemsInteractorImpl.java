package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login_success;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by I on 2017/9/1.
 */

public class FindItemsInteractorImpl implements FindItemsInteractor {
    @Override public void findItems(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listener.onFinished(createArrayList());
            }
        }, 2000);
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}
