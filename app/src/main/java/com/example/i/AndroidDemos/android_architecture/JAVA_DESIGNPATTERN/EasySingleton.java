package com.example.i.AndroidDemos.android_architecture.JAVA_DESIGNPATTERN;

import android.util.Log;

/***
 * Created by I on 2017/10/18.
 */

public enum EasySingleton {
    INSTANCE;
    private int age;

    EasySingleton() {
        this.age = age;
    }

    public void showAge() {
        Log.i("singleton", age + "");
    }

//    public static final void main(String[] args) throws InterruptedException {
//        EasySingleton.INSTANCE.showAge();
//    }
}
