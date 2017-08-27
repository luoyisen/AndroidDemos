package com.example.i.AndroidDemos.callbackdemo;

/**
 * Created by I on 2017/8/22.
 */

public class SalesMan {
    public void callToTell(CallBackPhoneNumber callBackPhoneNumber, String question) {//有了新货就打电话给之前留给我电话要买iphone的那个人
        callBackPhoneNumber.call(question);
    }
}

