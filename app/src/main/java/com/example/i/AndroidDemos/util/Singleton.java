package com.example.i.AndroidDemos.util;

/***
 * Created by I on 2017/10/18.
 */

public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}