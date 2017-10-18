package com.example.i.AndroidDemos.callbackdemo;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/***
 * Created by I on 2017/8/22.
 */

public class Customer implements SalesMan.CallBackPhoneNumber {
    private SalesMan salesMan;

    public Customer(SalesMan salesMan) {
        this.salesMan = salesMan;
    }

    public void askIfIphoneSoldOut(final String s) {
        Log.e("TAG", "iPhone不会是已经被一抢而空了吧？");

        boolean soldout = true;
        if (!soldout) {
            Log.e("TAG", "没那回事，iphone现货啦！！！速度来抢");
        } else {////如果iPhone卖光了，顾客才会留下电话号码让售货员在有新货的时候打电话通知他
            Log.e("TAG", "您猜对了，iphone现在断货啦！！！你把你的电话给我，有货了我就悄悄告诉你");

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    salesMan.callToTell(Customer.this, "新iPhone到了，赶紧来买！！！");//
                }
            }, 5000);
        }
        play();
    }

    private void play() {
        Log.e("TAG", "ok，那我就等你的好消息了");
    }

    @Override
    public void call(String result) {
        Log.e("TAG", "售货员告诉顾客：" + result);

    }
}
