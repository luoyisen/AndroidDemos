package com.example.i.AndroidDemos.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.fundamental.architecture.MyObserverable;
import com.example.i.AndroidDemos.fundamental.architecture.Observable;
import com.example.i.AndroidDemos.fundamental.architecture.Observer;


/***
 * Created by I on 2017/8/21.
 */

public class FragmentMain1 extends Fragment implements Observer {//观察者收到通知以后来做具体的事情，所以fragment实现了Observer接口
    TextView tv;
    Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, null);
        tv = (TextView) v.findViewById(R.id.text_showresult);
        MyObserverable.getObserverable().addObserver(this);//
        return v;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                switch (msg.what) {
//                    case 0:
//                        tv.setText(msg.obj.toString());
//                        break;
//                }
//            }
//        };
//    }

    @Override
    public void update(Observable observable, final Object data) {//观察者收到通知以后来做具体的事情，所以fragment实现了Observer接口
        tv.setText(data.toString());//执行具体的方法

    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
//            @Override
//            public void call(final Subscriber<? super String> subscriber) {
//                tv.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        subscriber.onNext(s.toString());
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//
//                    }
//                });
//            }
//        })
//                .debounce(1000, TimeUnit.MICROSECONDS)
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                tv1.setText(s);
//            }
//        });
//    }
}