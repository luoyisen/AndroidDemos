package com.example.i.AndroidDemos.fundamental.javadesignpattern.builder;

/**
 * Created by HHX on 2018/3/7.
 */

public abstract class BasketballPlayer {
    protected String name;

    public BasketballPlayer(String name) {
        this.name = name;
    }

    public abstract void attack();

    public abstract void defend();
}
