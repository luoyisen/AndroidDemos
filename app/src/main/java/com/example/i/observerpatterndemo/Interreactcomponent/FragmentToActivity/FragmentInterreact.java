package com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;
import com.example.i.observerpatterndemo.base.BaseFragmentWithRV;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 */

public class FragmentInterreact extends BaseFragmentWithRV {
    ArrayList arrayList;
    public BaseRVAdapter adapter;
    FragmentManager fragmentManager;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList = new ArrayList();
        arrayList.add("接口实现Fragment和包含该Fragment的Activity通信 \n" +
                "(仅限于该Fragment和包含它的Activity之间)");
        arrayList.add("Activity之间通过startActivityForResult()方法通信");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        arrayList.add("Csfasfsfasdf");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        fragmentManager = getFragmentManager();
                        setRootFragmentVisible();
                        FragmentLogin loginFragment = new FragmentLogin();
                        fragmentManager.beginTransaction().add(R.id.container_ll, loginFragment, "fragment0").commitNow();//通过tag来识别添加的是哪一个fragment
                        break;
                    case 1:
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {
            }
        });

    }

    private void setRootFragmentVisible() {
        getActivity().getSupportFragmentManager().beginTransaction().hide(fragmentManager.findFragmentByTag("fragment_root")).commit();
        getFragmentManager().findFragmentByTag("fragment_root").setUserVisibleHint(false);//因为show()和hide()方法不走Fragment的生命周期，所以需要手动设置
    }
}
