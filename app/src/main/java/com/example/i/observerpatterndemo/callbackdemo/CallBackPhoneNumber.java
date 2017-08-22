package com.example.i.observerpatterndemo.callbackdemo;

/**
 * Created by I on 2017/8/22.
 */

public interface CallBackPhoneNumber {//回调接口,该实例中是一个电话号码，用于售货员打电话给消费者货到了

    void call(String result);//回调时调用的函数
}
