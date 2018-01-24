package com.example.i.AndroidDemos.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.ui.fragment.FragmentMain1;
import com.example.i.AndroidDemos.ui.fragment.FragmentMain2;
import com.example.i.AndroidDemos.fundamental.architecture.MyObserverable;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * Created by I on 2017/9/20.
 */

public class ActivityObserverPattern extends AppCompatActivity {
    @BindView(R.id.click)
    Button click;
    private static ActivityObserverPattern.MyHandler myHandler;
    public static String editext_information;
    public static DrawerLayout drawerLayout;
    public SearchView searchview_main;
    private static EditText edit_query;
    private static int getMessageCount;
    private LinearLayout search_bar;
    private Timer timer;
    private TimerTask timerTask;
    private Runnable runnable;
    FragmentMain1 fragmentMain1;
    FragmentMain2 fragmentMain2;


    private static class MyHandler extends Handler {
        private final WeakReference<ActivityObserverPattern> activityObserverPatternWeakReference;

        MyHandler(ActivityObserverPattern activity) {
            activityObserverPatternWeakReference = new WeakReference<ActivityObserverPattern>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ActivityObserverPattern activity = activityObserverPatternWeakReference.get();
            if (activity != null) {
                switch (msg.what) {
                    case 0:
                        MyObserverable.getObserverable().setMessage(edit_query.getText().toString() + getMessageCount++);//用来发送通知(模拟耗时操作)
                        break;
                }
            }
        }
    }

    /**
     * Instances of anonymous classes do not hold an implicit
     * reference to their outer class when they are "static".
     */
//    private static final Runnable sRunnable = new Runnable() {
//        @Override
//        public void run() {
//            new Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + getMessageCount++ + "\"");//用来发送通知(模拟耗时操作)
//                }
//            }, 0, 1000);
//        }
//    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        ButterKnife.bind(this);
        myHandler = new MyHandler(this);

        fragmentMain1 = new FragmentMain1();
        fragmentMain2 = new FragmentMain2();

        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.add(R.id.fragmentmain1container, fragmentMain1, null);
        transaction1.commit();
        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.add(R.id.fragmentmain2container, fragmentMain2, "fragment2");
        transaction2.commit();
        edit_query = (EditText) findViewById(R.id.edit_query);
        editext_information = edit_query.getText().toString();
    }

    @OnClick(R.id.click)
    void click() {
        if (!TextUtils.isEmpty(edit_query.getText())) {
//            new Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    Message msg = new Message();
//                    msg.what = 0;
//                    myHandler.sendMessage(msg);
//                }
//            }, 3dpager1, 1000);

            runnable = new Runnable() {
                @Override
                public void run() {
                    MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + getMessageCount++ + "\"");//用来发送通知(模拟耗时操作)
                    myHandler.postDelayed(this, 1000);
//                    myHandler.removeCallbacks(runnable);// TODO: 2017/8/28 如果不添加这句，将会一直执行下去，就像用了timertask

                }
            };
            myHandler.post(runnable);
        }
    }
}
