package com.example.i.observerpatterndemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button_to;
    private EditText edit_query;
    private LinearLayout fragmentcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentcontainer = (LinearLayout) findViewById(R.id.fragmentcontainer);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentcontainer, new Fragment01(), null);
        transaction.commit();
        edit_query = (EditText) findViewById(R.id.edit_query);
        findViewById(R.id.button_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "MainActivity发送通知了", Toast.LENGTH_SHORT).show();
                MyObserverable.getObserverable().setMessage(edit_query.getText().toString());//用来发送通知
            }
        });
    }
}
