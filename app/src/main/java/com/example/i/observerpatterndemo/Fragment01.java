package com.example.i.observerpatterndemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by I on 2017/8/21.
 */

public class Fragment01 extends Fragment implements Observer {//观察者收到通知以后来做具体的事情，所以fragment实现了Observer接口
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, null);
        tv = (TextView) v.findViewById(R.id.text_showresult);
        MyObserverable.getObserverable().addObserver(this);//
        return v;
    }

    @Override
    public void update(Observable observable, Object data) {//观察者收到通知以后来做具体的事情，所以fragment实现了Observer接口
        Toast.makeText(getActivity().getApplicationContext(), "收到通知了", Toast.LENGTH_SHORT).show();
        tv.setText(data.toString());//执行具体的方法
    }
}