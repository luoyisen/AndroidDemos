package com.example.i.AndroidDemos;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by I on 2017/8/24.
 */

public class MyApplication extends Application {
    public static SharedPreferences sharedPreferences;
    public static  final  String LOGIN_STATE = "LOGIN_STATE";
    public static  final  String IS_LOGIN_SUCCESS = "IS_LOGIN_SUCCESS";

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getSharedPreferences(LOGIN_STATE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_LOGIN_SUCCESS, false);
    }
}
