package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login_success;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivity;

import java.util.List;

import static com.example.i.AndroidDemos.MyApplication.IS_LOGIN_SUCCESS;
import static com.example.i.AndroidDemos.MyApplication.LOGIN_STATE;

/***
 *
 * Created by I on 2017/9/3dpager1.
 */

public class Activity_LoginSuccess extends BaseActivity implements MainView, AdapterView.OnItemClickListener, View.OnClickListener {
    private ListView listView;
    private ProgressBar progressBar;
    private MainPresenter presenter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_loginsuccess;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        presenter = new MainPresenterImpl(this, new FindItemsInteractorImpl());
        presenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSnackBar(String information) {
        final Snackbar snackbar = Snackbar.make(listView, information, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(getResources().getColor(R.color.colorwhite));
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorread));
        snackbar.setAction("点击取消登陆", new View.OnClickListener() { // 设置点击事件
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(LOGIN_STATE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(IS_LOGIN_SUCCESS, false);
                editor.apply();
                finish();
                snackbar.dismiss();
            }
        }).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

    @Override
    public void onClick(View v) {

    }
}
