package com.example.i.AndroidDemos.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/9/12.
 */

public class DialogShowCodeView extends Dialog {
    private double density;


    public DialogShowCodeView(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DialogShowCodeView(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
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
        private int layoutResID;

        public Builder(Context context) {
            this.context = context;
        }

        public DialogShowCodeView.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public DialogShowCodeView.Builder setCancelAble(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public DialogShowCodeView.Builder setSpecifiedView(int viewId) {
            this.viewId = viewId;
            return this;
        }

        public DialogShowCodeView.Builder setLayoutResID(int layoutResID) {
            this.layoutResID = layoutResID;
            return this;
        }

        public DialogShowCustomizedView create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final DialogShowCustomizedView dialog = new DialogShowCustomizedView(context,
                    R.style.dialog);
            View layout = inflater.inflate(layoutResID, null);
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
                case 4:
                    layout.findViewById(R.id.id3).setVisibility(View.VISIBLE);
                    break;
                case 5:
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


        public DialogShowCodeView.Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }
    }

}
