package com.example.i.AndroidDemos.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i.AndroidDemos.Interreactcomponent.ActivityComponentIntereact;
import com.example.i.AndroidDemos.JAVA_BASE.ActivityJavaBase;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.algorithm.ActivityAlgorithm;
import com.example.i.AndroidDemos.android_architecture.ActivityArchitecture;
import com.example.i.AndroidDemos.callbackdemo.CallBackActivity;
import com.example.i.AndroidDemos.customizedview.ActivityCustomizedView;
import com.example.i.AndroidDemos.datastructure.ActivityDataStructure;
import com.example.i.AndroidDemos.main.base.BaseView;
import com.example.i.AndroidDemos.main.login.ui.LoginFragment;
import com.example.i.AndroidDemos.network.ActivityNet;
import com.example.i.AndroidDemos.noteandtools.ActivityNoteAndTools;
import com.example.i.AndroidDemos.observerpatterndemo.ActivityObserverPattern;
import com.example.i.AndroidDemos.opengl.ActivityOpenGl;
import com.example.i.AndroidDemos.util.DisplayMetricsConvert;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * Created by I on 2017/9/24.
 */

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, LoginFragment.LoginCallback, BaseView {
    @BindView(R.id.text_nodata)
    TextView text_nodata;
    private LoginFragment loginFragment;
    public static DrawerLayout drawerLayout;
    private SearchView searchview_main;
    private long firstclicktime = 0;
    float x1 = 0;
    float x2 = 0;

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        text_nodata.setText(stringFromJNI());
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutmain);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolabr_main);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setElevation(10.0f);
        }
        //这里的SearchView通过自定义style来控制搜索框中的搜索图标不显示
        searchview_main = (SearchView) findViewById(R.id.serchview_main);
        //SearchView的三种显示模式
        //searchview_main.setIconifiedByDefault(false);//这种模式下不能隐藏搜索框中的图标
        //searchview_main.setIconified(false);
        searchview_main.onActionViewExpanded();//后两种会自动打开软键盘，如果需要设置SearchView默认为不打开状态，则不能使用该模式，否则就算用该模式并设置取消SearchView焦点的方法，会导致软键盘弹出来并退出来一次。
        searchview_main.setQueryHint("search repos from github");
        //设置搜索框背景和大小
        LinearLayout ll_searchview = (LinearLayout) findViewById(R.id.search_edit_frame);
        ll_searchview.setBackground(getResources().getDrawable(R.drawable.shape_searchview));
        ll_searchview.setLayoutParams(new LinearLayout.LayoutParams(DisplayMetricsConvert.pxToDp(getApplicationContext(), 260), DisplayMetricsConvert.pxToDp(getApplicationContext(), 32)));
        //用来设置输入完成以后是否显示跳转按钮
        searchview_main.setSubmitButtonEnabled(false);
        //ImageView closeViewIcon = (ImageView)searchview_main.findViewById(R.id.search_close_btn);
        //closeViewIcon.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_location_searching_black_24dp));
        //用来设置searchView展开和不展开状态下的图标和
        LinearLayout search_bar = (LinearLayout) findViewById(R.id.search_bar);
        search_bar.setGravity(Gravity.CENTER);


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
                    case R.id.componentfinterreact:
                        startActivity(new Intent(MainActivity.this, ActivityObserverPattern.class));
                        break;
                    case R.id.frame:
                        startActivity(new Intent(MainActivity.this, ActivityJavaBase.class));
                        break;
                }
                drawerLayout.closeDrawer(Gravity.START);
                return true;
            }
        });
    }

    @OnClick(R.id.login)
    void login() {
        if (loginFragment == null) {
            loginFragment = new LoginFragment();
            loginFragment.setCallback(this);
        }
        if (loginFragment.getDialog() == null)
            loginFragment.show(getSupportFragmentManager(), "loginfragment");
        else loginFragment.getDialog().show();
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
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            x2 = event.getX();
            if (x2 - x1 > 50)
                drawerLayout.openDrawer(Gravity.START);
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        long nowtime = System.currentTimeMillis();
        if (nowtime - firstclicktime > 1500) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            firstclicktime = nowtime;
        } else {
            finish();
            System.exit(0);
        }
    }

    //baseView
    @Override
    public void showOnError(String s) {

    }

    @Override
    public void showOnLoading() {

    }

    @Override
    public void showOnSuccess() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public Context getViewContext() {
        return null;
    }

    //登陆
    @Override
    public void onSuccessToLogin() {

    }

    @Override
    public void onDismissLogin() {

    }
}
