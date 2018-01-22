package com.example.i.AndroidDemos.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;

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
        View view = ((LayoutInflater) MyApplication.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.note, null);
        TextView textView = view.findViewById(R.id.note_text);
        Drawable drawable =
                ToastyUtils.getDrawable(MyApplication.getInstance(), R.drawable.note_background);
        ToastyUtils.setBackground(view, drawable);
        textView.setText(msg);
        mToast.setView(view);
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
