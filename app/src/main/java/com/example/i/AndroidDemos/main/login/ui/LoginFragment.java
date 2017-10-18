package com.example.i.AndroidDemos.main.login.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.main.dagger2.ComponentHolder;
import com.example.i.AndroidDemos.main.login.loginPresenter.LoginContract;
import com.example.i.AndroidDemos.util.Note;
import com.example.i.AndroidDemos.util.Utils;

import javax.inject.Inject;

/***
 * Created by I on 2017/9/24.
 */

public class LoginFragment extends DialogFragment implements LoginContract.View {
    @Inject
    LoginContract.Presenter presenter;
    @Inject
    Context mCtx;
    private TextInputEditText editUsername;
    private TextInputLayout textWrapperUsername;
    private TextInputEditText editPassword;
    private TextInputLayout textWrapperPsw;
    private ProgressBar progressBar;
    private TextView tvLogin;
    private View mRootView;
    private boolean dismissable;
    private TextView tvCancel;

    private LoginCallback callback;

    @Override
    public void initData(Bundle savedInstanceState) {
        initDagger();
//        String loginUserName = presenter.getLoginUserName();
//        if (!TextUtils.isEmpty(loginUserName))
//            editUsername.setText(loginUserName);
    }

    private void initDagger() {
        ComponentHolder.getLoginComponent().inject(this);
//        presenter.attachView(this);
        if (presenter == null) {
            Toast.makeText(MyApplication.getContext(), "为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        presenter.detachView();
        Utils.leakWatch(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.frag_dialog_login;
    }

    @Override
    public void initView() {
        editUsername = (TextInputEditText) mRootView.findViewById(R.id.edit_username);
        textWrapperUsername = (TextInputLayout) mRootView.findViewById(R.id.text_wrapper_username);
        editPassword = (TextInputEditText) mRootView.findViewById(R.id.edit_password);
        textWrapperPsw = (TextInputLayout) mRootView.findViewById(R.id.text_wrapper_psw);
        progressBar = (ProgressBar) mRootView.findViewById(R.id.progressBar);
        tvLogin = (TextView) mRootView.findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
        tvCancel = (TextView) mRootView.findViewById(R.id.tv_cancel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dismissable)
                    dismiss();
                else getDialog().hide();
            }
        });
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void showOnError(String s) {
        toggle();
        Note.show(s);
    }

    @Override
    public void showOnLoading() {
        toggle();
    }

    private void toggle() {
        if (progressBar.getVisibility() == View.INVISIBLE && tvLogin.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
            tvLogin.setVisibility(View.INVISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            tvLogin.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showOnSuccess() {
        toggle();
        if (callback != null)
            callback.onSuccessToLogin();
    }

    public void setDismissable(boolean dismissable) {
        this.dismissable = dismissable;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.frag_dialog_login, container, false);
            initView();
            initData(null);
        }
        return mRootView;
    }

    private void submit() {
        // validate
        String username = editUsername.getText().toString().trim();
        textWrapperUsername.setError(null);
        if (TextUtils.isEmpty(username)) {
            textWrapperUsername.setError(MyApplication.getContext().getString(R.string.error_null_username));// TODO: 2017/9/24
            return;
        }

        String password = editPassword.getText().toString().trim();
        textWrapperPsw.setError(null);
        if (TextUtils.isEmpty(password)) {
            textWrapperPsw.setError(MyApplication.getContext().getString(R.string.error_null_password));// TODO: 2017/9/24
            return;
        }
//        presenter.login(username, password);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
//        setCancelable(false);//To avoid cancel the dialog by pressing BACK key.Note: don't invoke the Dialog#setCancelable instead.
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (!dismissable && getDialog() != null) {
            getDialog().hide();
            return;
        }
        if (callback != null)
            callback.onDismissLogin();
        super.onDismiss(dialog);
    }

    public void setCallback(LoginCallback callback) {
        this.callback = callback;
    }

    public interface LoginCallback {
        void onSuccessToLogin();

        void onDismissLogin();
    }
}
