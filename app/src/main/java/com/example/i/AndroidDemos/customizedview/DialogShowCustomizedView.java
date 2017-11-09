package com.example.i.AndroidDemos.customizedview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.customizedview.customizedview.AlbumUtils;
import com.example.i.AndroidDemos.customizedview.customizedview.CicleRotateAlbumView;
import com.example.i.AndroidDemos.customizedview.customizedview.ProgressBarWithNumber.OnProgressBarListener;
import com.example.i.AndroidDemos.customizedview.customizedview.ProgressBarWithNumber.ProgressBarWithNumber;
import com.example.i.AndroidDemos.customizedview.customizedview.ViewChangeText;
import com.example.i.AndroidDemos.customizedview.customizedview.ViewProgressBarAutoSwitch;

import java.util.Timer;
import java.util.TimerTask;

/***
 * Created by I on 2017/8/30.
 */

public class DialogShowCustomizedView extends Dialog {
    private double density;
    private ViewChangeText viewChangeText;
    private ProgressBarWithNumber progressBarWithNumber;
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


    public static class Builder implements OnProgressBarListener {
        private ProgressBarWithNumber progressBarWithNumber;
        private Context context;
        private String title;
        private boolean cancelable;
        private int viewId;
        private Timer timer;
        private Handler handler;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        Builder setCancelAble(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        Builder setSpecifiedView(int viewId) {
            this.viewId = viewId;
            return this;
        }

        public DialogShowCustomizedView create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final DialogShowCustomizedView dialog = new DialogShowCustomizedView(context,
                    R.style.dialog);
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0x124) {
                        progressBarWithNumber.incrementProgressBy(1);
                    }
                }
            };
            View layout;
            if (inflater != null) {
                layout = inflater.inflate(R.layout.dialog_showcustomizedview, null);
                dialog.addContentView(layout, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    layout.findViewById(R.id.id2).setElevation(20f);
                    layout.findViewById(R.id.id2).setTranslationZ(20f);
                }
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
                        layout.findViewById(R.id.id4).setVisibility(View.VISIBLE);
                        CicleRotateAlbumView cicleRotateAlbumView = (CicleRotateAlbumView) layout.findViewById(R.id.id4);

                        Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.getContext().getResources(), R.mipmap.yingmuhuadao);
                        cicleRotateAlbumView.setImageBitmap(AlbumUtils.getCroppedBitmap(bitmap));
                        break;
                    case 5:
                        layout.findViewById(R.id.id5).setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        layout.findViewById(R.id.id6).setVisibility(View.VISIBLE);
                        progressBarWithNumber = (ProgressBarWithNumber) layout.findViewById(R.id.id6);
                        progressBarWithNumber.setOnProgressBarListener(this);
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                handler.sendEmptyMessage(0x124);
                            }
                        }, 1000, 100);
                        progressBarWithNumber.incrementProgressBy(2);

                        break;
                    case 7:
                        layout.findViewById(R.id.id7).setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        layout.findViewById(R.id.id8).setVisibility(View.VISIBLE);
                        break;
                }
                if (cancelable) {
                    dialog.setCanceledOnTouchOutside(true);
                } else {
                    dialog.setCanceledOnTouchOutside(false);
                }
                dialog.setContentView(layout);
            }
            return dialog;
        }


        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        @Override
        public void onProgressChange(int current, int max) {
            if (current == max) {
                Toast.makeText(MyApplication.getContext(), "完工了", Toast.LENGTH_SHORT).show();
                progressBarWithNumber.setProgress(0);
            }
        }

    }


}
