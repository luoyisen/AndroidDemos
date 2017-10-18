package com.example.i.AndroidDemos.util;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;

/***
 * Created by I on 2017/9/24.
 */

public class Note {
    //Singleton pattern to use Toast.
    private static Toast mToast;

    public static void show(String msg) {
        if (mToast == null)
            mToast = Toast.makeText(MyApplication.getContext(), null, Toast.LENGTH_SHORT);
        mToast.setText(msg);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showBar(String msg, View view) {
        getSnackbar(msg, view)
                .show();
    }

    @NonNull
    public static Snackbar getSnackbar(String msg, View view) {
        return Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        super.onDismissed(snackbar, event);
//                        RxBusPostman.postQuickReturnEvent(true);
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        super.onShown(snackbar);
//                        RxBusPostman.postQuickReturnEvent(false);
                    }
                });
    }
}
