package com.example.i.AndroidDemos;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.i.AndroidDemos.Interreactcomponent.ActivityComponentIntereact;
import com.example.i.AndroidDemos.callbackdemo.CallBackActivity;
import com.example.i.AndroidDemos.eventdispatchdemo.EventDispatchActivity;
import com.example.i.AndroidDemos.network.ActivityNet;
import com.example.i.AndroidDemos.noteandtools.ActivityNoteAndTools;
import com.example.i.AndroidDemos.observerpatterndemo.FragmentMain1;
import com.example.i.AndroidDemos.observerpatterndemo.FragmentMain2;
import com.example.i.AndroidDemos.observerpatterndemo.MyObserverable;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private EditText edit_query;
    private LinearLayout fragmentcontainer1, fragmentcontainer2;
    private Timer timer;
    private TimerTask timerTask;
    private int getMessageCount;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentcontainer1 = (LinearLayout) findViewById(R.id.fragmentmain1container);
        fragmentcontainer2 = (LinearLayout) findViewById(R.id.fragmentmain2container);
        FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
        transaction1.add(R.id.fragmentmain1container, new FragmentMain1(), null);
        transaction1.commit();
        FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
        transaction2.add(R.id.fragmentmain2container, new FragmentMain2(), null);
        transaction2.commit();
        edit_query = (EditText) findViewById(R.id.edit_query);
        findViewById(R.id.button_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "MainActivity发送通知了", Toast.LENGTH_SHORT).show();
//                new Timer().schedule(new TimerTask() {
//                    //Timertask runs on a different thread. So you cannot not update/access ui from a background thread.
//                    @Override
//                    public void run() {
//                        MyObserverable.getObserverable().setMessage("adfadf");//用来发送通知(模拟耗时操作)
//                    }
//                }, 5000);//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        MyObserverable.getObserverable().setMessage("edit_query.getText().toString()");//用来发送通知(模拟耗时操作)
//                    }
//                });VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV

//                Handler m_handler;
//                m_handler = new Handler();
//                m_handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + "\"");//用来发送通知(模拟耗时操作)
//
//                    }
//                }, 4000);

//                final Handler handler = new Handler() {
//                    @Override
//                    public void handleMessage(Message msg) {
//                        switch (msg.what) {
//                            case 0:
//                                MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + getMessageCount++ + "\"");//用来发送通知(模拟耗时操作)
//                                break;
//                        }
//                    }
//                };
//
//                timerTask = new TimerTask() {
//                    @Override
//                    public void run() {
//                        Message message = new Message();
//                        message.what = 0;
//                        handler.sendMessage(message);
//                    }
//                };
//                /**
//                 *   * Creates a new timer whose associated thread may be specified to
//                 * {@linkplain Thread#setDaemon run as a daemon}.
//                 * A daemon thread is called for if the timer will be used to
//                 * schedule repeating "maintenance activities", which must be
//                 * performed as long as the application is running, but should not
//                 * prolong the lifetime of the application.
//                 *
//                 * @param isDaemon true if the associated thread should run as a daemon.
//                 */
//
//                timer = new Timer(true);//参数的意义
//                timer.schedule(timerTask, 1000, 1000);

                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + getMessageCount++ + "\"");//用来发送通知(模拟耗时操作)
                        handler.postDelayed(this, 2000);
//                        handler.removeCallbacks(runnable);// TODO: 2017/8/28 如果不添加这句，将会一直执行下去，就像用了timertask
                    }
                };
                handler.postDelayed(runnable, 2000);//每两秒执行一次runnable.

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.note:
                startActivity(new Intent(MainActivity.this, ActivityNoteAndTools.class));
                break;
            case R.id.huidiao:
                startActivity(new Intent(MainActivity.this, CallBackActivity.class));
                break;
            case R.id.eventdiapatch:
                startActivity(new Intent(MainActivity.this, EventDispatchActivity.class));
                break;
            case R.id.componentinterreact:
                startActivity(new Intent(MainActivity.this, ActivityComponentIntereact.class));
                break;
            case R.id.network:
                startActivity(new Intent(MainActivity.this, ActivityNet.class));
                break;
        }
        return true;
    }
}
