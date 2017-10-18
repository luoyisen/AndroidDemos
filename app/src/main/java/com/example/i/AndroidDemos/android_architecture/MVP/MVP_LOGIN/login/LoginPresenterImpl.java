package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login;

/***
 * Created by I on 2017/9/1.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.onLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(username, password, this);//能将this作为参数传递，是因为该类实现了onLoginFinishedListener接口//传递接口进来才能判断到底是用户名出错了还是密码出错了

    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if(loginView != null){
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView != null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(loginView != null){
            loginView.showLoginSuccessActivity();
        }
    }
}
