package com.example.i.AndroidDemos.callbackdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.callbackdemo.classtest.ChoiceAlertDialog;
import com.example.i.AndroidDemos.callbackdemo.classtest.ResultListener;

/***
 * Created by I on 2017/8/22.
 */

public class CallBackActivity extends AppCompatActivity {
    Button buttonCallback;
    MyButton myButton;
    SalesMan salesMan = new SalesMan();
    Customer customer = new Customer(salesMan);
    ChoiceAlertDialog choiceAlertDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        choiceAlertDialog = new ChoiceAlertDialog(this);
        myButton = (MyButton) findViewById(R.id.mynewbutton);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            myButton.setElevation(20f);
            myButton.setTranslationZ(20f);
        }
        myButton.setOnMyClickListener(new MyButton.OnMyClickListener() {
            @Override
            public void onMyClick(Button button) {
            }
        });
        myButton.doWork();//模拟点击事件
        buttonCallback = (Button) findViewById(R.id.button_callback);
        buttonCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choiceAlertDialog.getWindow().setBackgroundDrawableResource(R.drawable.shape_roundedcorner_white);
                choiceAlertDialog.setQuestion("单片机中，需要接上拉电阻的I/O端口是（ ）");
                choiceAlertDialog.setChoiceA("p0");
                choiceAlertDialog.setChoiceB("p1");
                choiceAlertDialog.setChoiceC("p2");
                choiceAlertDialog.setChoiceD("p3");
                choiceAlertDialog.setCancelable(false);
                choiceAlertDialog.setOnSettingListener(new ResultListener() {
                    @Override
                    public void onResult(boolean a, boolean b, boolean c, boolean d) {
                        if (a && !b && !c && !d) {
                        } else {
                        }
                    }
                });
                choiceAlertDialog.show();
                customer.askIfIphoneSoldOut("新到的iPhone还有卖的吗？");
            }
        });
    }
}
