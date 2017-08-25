package com.example.i.observerpatterndemo.callbackdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.i.observerpatterndemo.R;

/**
 * Created by I on 2017/8/22.
 */

public class CallBackActivity extends AppCompatActivity {
    Button buttonCallback;
    SalesMan salesMan = new SalesMan();
    Customer customer = new Customer(salesMan);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        buttonCallback = (Button) findViewById(R.id.button_callback);
        buttonCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer.askIfIphoneSoldOut("新到的iPhone还有卖的吗？");
            }
        });
    }
}
