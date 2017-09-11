package com.example.i.AndroidDemos.callbackdemo;

/**
 * Created by I on 2017/8/22.
 */

public class SalesMan {
    public void callToTell(CallBackPhoneNumber callBackPhoneNumber, String question) {//有了新货就打电话给之前留给我电话要买iphone的那个人
        callBackPhoneNumber.call(question);
    }
    public interface CallBackPhoneNumber {//回调接口,该实例中是一个电话号码，用于售货员打电话给消费者货到了

        void call(String result);//回调时调用的函数
    }
}

