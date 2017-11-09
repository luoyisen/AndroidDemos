package com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login;

import android.os.Handler;
import android.text.TextUtils;

/***
 * Created by I on 2017/9/3dpager1.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String username, final String password, final onLoginFinishedListener listener) {//final  ,因为内部要使用
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
