package com.example.i.AndroidDemos.basicPoint.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.util.Note;
import com.orhanobut.logger.Logger;

/**
 * 在manifest中配置IntentService，主要配置action
 * intentservice只有一个工作线程，名字就是构造函数的那个字符串，也就是“myIntentService”，我们知道多次开启service，
 * 只会调用一次onCreate方法（创建一个工作线程），多次onStartCommand方法（用于传入intent通过工作队列再发给onHandleIntent函数做处理）。
 */

public class MyIntentService extends IntentService {
    /**
     * 1.Service不是独立的进程，也不是独立的线程，它是依赖于应用程序的主线程的，不建议在Service中编写耗时的逻辑和操作，否则会引起ANR。
     * 2.IntentService创建了一个独立的工作线程来处理所有的通过onStartCommand()传递给服务的intents（把intent插入到工作队列中）。
     * 3.通过工作队列把intent逐个发送给onHandleIntent()。
     * 4.不需要主动调用stopSelft()来结束服务。因为，在所有的intent被处理完后，系统会自动关闭服务。
     * 5.默认实现的onBind()返回null。
     */
    public MyIntentService() {
        /**
         * IntentService的构造函数一定是参数为空的构造函数，然后再在其中调用super(“name”)这种形式的构造函数。
         * 因为Service的实例化是系统来完成的，而且系统是用参数为空的构造函数来实例化Service的
         */
        super("MyIntentService");//构造函数为空，这个字符串就是WorkerThread的名字。
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //同一服务只会开启一个worker thread，在onHandleIntent函数里依次处理intent请求,一次只会处理一个请求，该请求处理完成以后才会处理下一个。
        switch (intent.getExtras().getString("taskName")) {
            case "task1":
//                Note.show("task1");
                Toast.makeText(MyApplication.getInstance(),"task1",Toast.LENGTH_LONG).show();
                Logger.e("intentservice:task1");
                break;
            case "task2":
                Note.show("task2");
                Logger.e("intentservice:task2");
                break;
            case "task3":
                Note.show("task3");
                Logger.e("intentservice:task3");

                break;
        }
    }
}
