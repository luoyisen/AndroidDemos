package com.example.i.AndroidDemos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.i.AndroidDemos.Interreactcomponent.ActivityComponentIntereact;
import com.example.i.AndroidDemos.algorithm.ActivityAlgorithm;
import com.example.i.AndroidDemos.android_architecture.ActivityArchitecture;
import com.example.i.AndroidDemos.callbackdemo.CallBackActivity;
import com.example.i.AndroidDemos.customizedview.ActivityCustomizedView;
import com.example.i.AndroidDemos.datastructure.ActivityDataStructure;
import com.example.i.AndroidDemos.network.ActivityNet;
import com.example.i.AndroidDemos.noteandtools.ActivityNoteAndTools;
import com.example.i.AndroidDemos.observerpatterndemo.FragmentMain1;
import com.example.i.AndroidDemos.observerpatterndemo.FragmentMain2;
import com.example.i.AndroidDemos.observerpatterndemo.MyObserverable;
import com.example.i.AndroidDemos.opengl.ActivityOpenGl;
import com.example.i.AndroidDemos.util.DisplayMetricsConvert;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    public static DrawerLayout drawerLayout;
    public static SearchView searchview_main;
    private static EditText edit_query;
    private static int getMessageCount;
    private LinearLayout fragmentcontainer1, fragmentcontainer2, ll_searchview, search_bar;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler;
    private Runnable runnable;
    private ImageView search_mag_icon;
    FragmentMain1 fragmentMain1;
    FragmentMain2 fragmentMain2;

    private int startX;

//    private static class MyHandler extends Handler {
//        private final WeakReference<MainActivity> mainActivityWeakReference;
//
//        public MyHandler(MainActivity activity) {
//            mainActivityWeakReference = new WeakReference<MainActivity>(activity);
//        }
//
//        @Override
//        public void handleMessage(Message msg) {
//            MainActivity activity = mainActivityWeakReference.get();
//            if (activity != null) {
//            }
//        }
//    }
//
//    public final MyHandler mHandler = new MyHandler(this);
//
//    /**
//     * Instances of anonymous classes do not hold an implicit
//     * reference to their outer class when they are "static".
//     */
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        fragmentcontainer1 = (LinearLayout) findViewById(R.id.fragmentmain1container);
        fragmentcontainer2 = (LinearLayout) findViewById(R.id.fragmentmain2container);
        fragmentMain1 = new FragmentMain1();
        fragmentMain2 = new FragmentMain2();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutmain);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolabr_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setElevation(200.0f);
        //这里的SearchView通过自定义style来控制搜索框中的搜索图标不显示
        searchview_main = (SearchView) findViewById(R.id.serchview_main);
        //SearchView的三种显示模式
        //searchview_main.setIconifiedByDefault(false);//这种模式下不能隐藏搜索框中的图标
        //searchview_main.setIconified(false);
        searchview_main.onActionViewExpanded();//后两种会自动打开软键盘，如果需要设置SearchView默认为不打开状态，则不能使用该模式，否则就算用该模式并设置取消SearchView焦点的方法，会导致软键盘弹出来并退出来一次。
        searchview_main.setQueryHint("search github");
        //设置搜索框背景和大小
        ll_searchview = (LinearLayout) findViewById(R.id.search_edit_frame);
        ll_searchview.setBackground(getResources().getDrawable(R.drawable.shape_searchview));
        ll_searchview.setLayoutParams(new LinearLayout.LayoutParams(DisplayMetricsConvert.pxToDp(getApplicationContext(), 260), DisplayMetricsConvert.pxToDp(getApplicationContext(), 32)));
        //用来设置输入完成以后是否显示跳转按钮
        searchview_main.setSubmitButtonEnabled(false);
        //ImageView closeViewIcon = (ImageView)searchview_main.findViewById(R.id.search_close_btn);
        //closeViewIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_location_searching_black_24dp));
        //用来设置searchView展开和不展开状态下的图标和
        search_bar = (LinearLayout) findViewById(R.id.search_bar);
        search_bar.setGravity(Gravity.CENTER);
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.add(R.id.fragmentmain1container, fragmentMain1, null);
        transaction1.commit();
        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.add(R.id.fragmentmain2container, fragmentMain2, null);
        transaction2.commit();
        edit_query = (EditText) findViewById(R.id.edit_query);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.note:
                        startActivity(new Intent(MainActivity.this, ActivityNoteAndTools.class));
                        break;
                    case R.id.huidiao:
                        startActivity(new Intent(MainActivity.this, CallBackActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        break;
                    case R.id.componentinterreact:
                        startActivity(new Intent(MainActivity.this, ActivityComponentIntereact.class));
                        break;
                    case R.id.network:
                        startActivity(new Intent(MainActivity.this, ActivityNet.class));
                        break;
                    case R.id.customizedview:
                        startActivity(new Intent(MainActivity.this, ActivityCustomizedView.class));
                        break;
                    case R.id.architecture:
                        startActivity(new Intent(MainActivity.this, ActivityArchitecture.class));
                        break;
                    case R.id.algorithm:
                        startActivity(new Intent(MainActivity.this, ActivityAlgorithm.class));
                        break;
                    case R.id.dataStructure:
                        startActivity(new Intent(MainActivity.this, ActivityDataStructure.class));
                        break;
                    case R.id.opengl:
                        startActivity(new Intent(MainActivity.this, ActivityOpenGl.class));
                        break;
                }
                drawerLayout.closeDrawer(Gravity.START);
                return true;
            }
        });

        findViewById(R.id.button_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxx((((((1)))))))xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//                mHandler.postDelayed(sRunnable, 1000);
//xxxxxxxxxxxxxxxxxxxxxxxxxxxx(((((((2))))))xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//                new Timer().schedule(new TimerTask() {
//                    //Timertask runs on a different thread. So you cannot not update/access ui from a background thread.
//                    @Override
//                    public void run() {
//                        MyObserverable.getObserverable().setMessage("adfadf");//用来发送通知(模拟耗时操作)
//                    }
//                }, 5000);//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        MyObserverable.getObserverable().setMessage("edit_query.getText().toString()");//用来发送通知(模拟耗时操作)
//                    }
//                });
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
//                延迟发送
//                Handler m_handler;
//                m_handler = new Handler();
//                m_handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + "\"");//用来发送通知(模拟耗时操作)
//                    }
//                }, 4000);
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
//              每一秒执行一次//如果内部类的生命周期和Activity的生命周期不一致（比如上面那种，Activity finish()之后要等10分钟，内部类的实例才会执行），则在Activity中要避免使用非静态的内部类，这种情况，就使用一个静态内部类，同时持有一个对Activity的WeakReference。
                handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case 0:
                                MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + getMessageCount++ + "\"");//用来发送通知(模拟耗时操作)
                                break;
                        }
                    }
                };
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = 0;
                        handler.sendMessage(message);
                    }
                }, 0, 1000);
//----------------------------------------------------------------------------------------------------
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
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
//////              每一秒执行一次
//                        runnable = new Runnable() {
//                    @Override
//                    public void run() {
//                        MyObserverable.getObserverable().setMessage("\"" + edit_query.getText().toString() + getMessageCount++ + "\"");//用来发送通知(模拟耗时操作)
//                        handler.postDelayed(this, 1000);
////                        handler.removeCallbacks(runnable);// TODO: 2017/8/28 如果不添加这句，将会一直执行下去，就像用了timertask
//
//                    }
//                };
//                handler = new Handler();
//                handler.post(runnable);
//--------------------------------------------------------------------------------------------------------
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(this, "down了", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
