package com.example.i.observerpatterndemo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.i.observerpatterndemo.Interreactcomponent.ComponentIntereactActivity;
import com.example.i.observerpatterndemo.callbackdemo.CallBackActivity;
import com.example.i.observerpatterndemo.eventdispatchdemo.EventDispatchActivity;
import com.example.i.observerpatterndemo.network.ActivityNet;
import com.example.i.observerpatterndemo.note.NoteActivity;
import com.example.i.observerpatterndemo.observerpatterndemo.Fragment01;
import com.example.i.observerpatterndemo.observerpatterndemo.MyObserverable;

public class MainActivity extends Activity {
    private EditText edit_query;
    private LinearLayout fragmentcontainer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentcontainer = (LinearLayout) findViewById(R.id.fragmentcontainer);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentcontainer, new Fragment01(), null);
        transaction.commit();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setBackgroundColor(Color.parseColor("#3c5f78"));
        edit_query = (EditText) findViewById(R.id.edit_query);
        findViewById(R.id.button_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "MainActivity发送通知了", Toast.LENGTH_SHORT).show();
                MyObserverable.getObserverable().setMessage(edit_query.getText().toString());//用来发送通知
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.note:
                        startActivity(new Intent(MainActivity.this, NoteActivity.class));
                        break;
                    case R.id.huidiao:
                        startActivity(new Intent(MainActivity.this, CallBackActivity.class));
                        break;
                    case R.id.eventdiapatch:
                        startActivity(new Intent(MainActivity.this, EventDispatchActivity.class));
                        break;
                    case R.id.componentinterreact:
                        startActivity(new Intent(MainActivity.this, ComponentIntereactActivity.class));
                        break;
                    case R.id.network:
                        startActivity(new Intent(MainActivity.this, ActivityNet.class));
                        break;
                }
                return false;
            }
        });
    }
}
