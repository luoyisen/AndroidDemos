package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login_success.Activity_LoginSuccess;
import com.example.i.AndroidDemos.base.BaseFragment;

import static com.example.i.AndroidDemos.MyApplication.IS_LOGIN_SUCCESS;
import static com.example.i.AndroidDemos.MyApplication.LOGIN_STATE;

/***
 * Created by I on 2017/9/3dpager1.
 */

public class Fragment_Mvp extends BaseFragment implements LoginView, View.OnClickListener {
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;
    private MyApplication myApplication;//用application记录登陆状态不持久，退出以后又要登陆

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mvp;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        view.findViewById(R.id.button).setOnClickListener(this);
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onDestroy() {// TODO: 2017/9/3dpager1 检查
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void showLoginSuccessActivity() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(LOGIN_STATE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_LOGIN_SUCCESS, true);
        editor.apply();
        startActivity(new Intent(getActivity(), Activity_LoginSuccess.class));
        progressBar.setVisibility(View.GONE);
    }
}
