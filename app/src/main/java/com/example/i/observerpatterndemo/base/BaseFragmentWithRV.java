package com.example.i.observerpatterndemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity.MyListener;
import com.example.i.observerpatterndemo.Interreactcomponent.InterreactDecoration;
import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;

/**
 * Created by I on 2017/8/26.
 */

public class BaseFragmentWithRV extends BaseFragment {
    public RecyclerView rv_base_fragment;  //必须为public，公用的
    public RecyclerView.LayoutManager mLayoutManager;
    public BaseRVAdapter adapter;
    public FragmentManager fragmentManager;
    public MyListener myListener;


    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_base_withrv;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentManager = getFragmentManager();
        rv_base_fragment = (RecyclerView) getActivity().findViewById(R.id.rv_basefragment);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_base_fragment.setLayoutManager(mLayoutManager);//必须设置
        rv_base_fragment.addItemDecoration(new InterreactDecoration(getActivity(), LinearLayoutManager.VERTICAL));
    }

    public void hideRootFragment() {
        fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("fragment_root")).commit();
        fragmentManager.findFragmentByTag("fragment_root").setUserVisibleHint(false);//因为show()和hide()方法不走Fragment的生命周期，所以需要手动设置
    }

    public void addFragment(Fragment fragment, String tag) {
        hideRootFragment();
        fragmentManager.beginTransaction().add(R.id.container_ll, fragment, tag).commit();//通过tag来识别添加的是哪一个fragment
        fragment.setUserVisibleHint(true);
    }

    public void showFragment(Fragment fragment) {
        hideRootFragment();
        fragmentManager.beginTransaction().show(fragment).commit();
        fragment.setUserVisibleHint(true);
    }
    @Override
    public void onAttach(Context context) {//onAttach方法有两个重载，一个传递的参数是Activity，一个是Context，传递参数为context的在一些Android版本上面由bug，(如果是使用的Fragment包，而不是v4.support.fragment包就会有);
        super.onAttach(context);
        //This makes sure that the container activity has implemented the callback interface. If not, it throws an exception

        //加入判断:
        if (context instanceof MyListener) {//如果该Fragment Attach的Activity实现了MyListener接口
            myListener = (MyListener) context;//实例化该接口
        }
        //或者捕获异常
//        try {
//            mylistener = (MyListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + "包含该Fragment的Activity必须实现MyListener接口");
//        }
    }
}
