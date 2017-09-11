package com.example.i.AndroidDemos.callbackdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/8/22.
 */

public class CallBackActivity extends AppCompatActivity {
    Button buttonCallback;
    MyButton myButton;
    SalesMan salesMan = new SalesMan();
    Customer customer = new Customer(salesMan);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        myButton = (MyButton) findViewById(R.id.mynewbutton);
//        myButton.setOnMyClickListener(new MyButton.OnMyClickListener() {
//            @Override
//            public void onMyClick(View view) {
//                Toast.makeText(CallBackActivity.this, "自定义的回调", Toast.LENGTH_SHORT).show();
//            }
//        });
        buttonCallback = (Button) findViewById(R.id.button_callback);
        buttonCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer.askIfIphoneSoldOut("新到的iPhone还有卖的吗？");
            }
        });
    }
}
