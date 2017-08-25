package com.example.i.observerpatterndemo.eventdispatchdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.i.observerpatterndemo.R;

/**
 * Created by I on 2017/8/22.
 */

public class EventDispatchActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdiapatch);
        findViewById(R.id.btn_clickme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventDispatchActivity.this, "button被点击了", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
