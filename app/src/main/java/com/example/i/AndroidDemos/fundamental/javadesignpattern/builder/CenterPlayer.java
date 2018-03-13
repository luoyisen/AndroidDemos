package com.example.i.AndroidDemos.fundamental.javadesignpattern.builder;

import com.orhanobut.logger.Logger;

/**
 * Created by HHX on 2018/3/7.
 */

public class CenterPlayer extends BasketballPlayer {

    public CenterPlayer(String name) {
        super(name);
    }

    @Override
    public void attack() {
        Logger.e("adaptertest:" + "CenterPlayer::attack");
    }

    @Override
    public void defend() {
        Logger.e("adaptertest:" + "CenterPlayer::defend");
    }
}
