package com.example.i.observerpatterndemo.Interreactcomponent;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.i.observerpatterndemo.note.NoteDialogWithConfig;

/**
 * Created by I on 2017/8/23.
 */

public class IImageView extends AppCompatImageView {

    public IImageView(Context context) {
        super(context);
    }

    public IImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                NoteDialogWithConfig.Builder customBuilder = new
                        NoteDialogWithConfig.Builder(getContext());
                customBuilder.setTitle("Android Studio KeyMap")
                        .setMessage("查看类的层级关系:CTRL + H\n" +
                                "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf")
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                    }
                                })
                        .setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                        .setCancelAble(true);

                customBuilder.create().show();
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;//表示自己处理事件，事件不再向上传递了
    }


}
