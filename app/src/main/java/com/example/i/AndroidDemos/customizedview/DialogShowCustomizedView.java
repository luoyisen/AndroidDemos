package com.example.i.AndroidDemos.customizedview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.customizedview.customizedview.ViewChangeText;
import com.example.i.AndroidDemos.customizedview.customizedview.ViewProgressBarAutoSwitch;

/**
 * Created by I on 2017/8/30.
 */

public class DialogShowCustomizedView extends Dialog {
    private double density;
    private ViewChangeText viewChangeText;
    private ViewProgressBarAutoSwitch viewProgressBarAutoSwitch;

    //在代码中用的就是这个构造函数
    public DialogShowCustomizedView(@NonNull Context context) {
        super(context);
    }

    //该构造函数可以控制Dialog主题
    public DialogShowCustomizedView(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    //该构造函数可以设置点击dialog外部是否可以取消掉Dialog
    public DialogShowCustomizedView(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.height = (int) dipToPx(400);
        layoutParams.width = (int) dipToPx(300);
        window.setAttributes(layoutParams);
        //window.setDimAmount(0.7f);设置Dialog的透明度
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private double dipToPx(int i) {
        density = getContext().getResources().getDisplayMetrics().density;
        return i * density + 0.5 * density;
    }

    public static class Builder {

        private Context context;
        private String title;
        private boolean cancelable;
        private int viewId;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setCancelAble(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setSpecifiedView(int viewId) {
            this.viewId = viewId;
            return this;
        }

        public DialogShowCustomizedView create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final DialogShowCustomizedView dialog = new DialogShowCustomizedView(context,
                    R.style.dialog);
            View layout = inflater.inflate(R.layout.dialog_showcustomizedview, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            ((TextView) layout.findViewById(R.id.title)).setText(title);
            switch (viewId) {
                case 0:
                    layout.findViewById(R.id.id0).setVisibility(View.VISIBLE);
                    break;
                case 1:
                    layout.findViewById(R.id.id1).setVisibility(View.VISIBLE);
                    break;
                case 2:
                    layout.findViewById(R.id.id2).setVisibility(View.VISIBLE);
                    break;
                case 3:
                    layout.findViewById(R.id.id3).setVisibility(View.VISIBLE);
                    break;
            }
            if (cancelable == true) {
                dialog.setCanceledOnTouchOutside(true);
            } else {
                dialog.setCanceledOnTouchOutside(false);
            }
            dialog.setContentView(layout);
            return dialog;
        }


        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }
    }

}
