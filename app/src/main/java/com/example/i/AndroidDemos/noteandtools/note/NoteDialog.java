package com.example.i.AndroidDemos.noteandtools.note;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Window;
import android.view.WindowManager;

import com.example.i.AndroidDemos.R;

/**
 * Created by I on 2017/8/26.
 */

public class NoteDialog extends Dialog {
    Context context;
    private double density;

    //在代码中用的就是这个构造函数
    public NoteDialog(@NonNull Context context) {
        super(context);
    }

    //该构造函数可以控制Dialog主题
    public NoteDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    //该构造函数可以设置点击dialog外部是否可以取消掉Dialog
    public NoteDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_note);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.height = (int) dipToPx(400);
        layoutParams.width = (int) dipToPx(300);
        window.setAttributes(layoutParams);

    }

    private double dipToPx(int i) {
        density = getContext().getResources().getDisplayMetrics().density;
        return i * density + 0.5 * density;
    }

}
