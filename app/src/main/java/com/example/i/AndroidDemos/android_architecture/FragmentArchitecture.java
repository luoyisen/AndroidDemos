package com.example.i.AndroidDemos.android_architecture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login.Fragment_Mvp;
import com.example.i.AndroidDemos.android_architecture.MVP.MVP_LOGIN.login_success.Activity_LoginSuccess;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;

import java.util.ArrayList;

/**
 * Created by I on 2017/9/1.
 */

public class FragmentArchitecture extends BaseFragmentWithRV {
    ArrayList arrayList;
    Fragment_Mvp fragment_mvp;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment_mvp = new Fragment_Mvp();
        arrayList = new ArrayList();
        arrayList.add("MVP_LOGIN");
        arrayList.add("MVP_TODO");
        arrayList.add("ANDROID_MVVM");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("loginstate", Context.MODE_PRIVATE);
                        if ((sharedPreferences.getString("isloginsuccess", "failed")) == "failed") {
                            displayFragment(fragment_mvp, "FragmentArchitecture0");
                            if (myListener != null) {
                                myListener.sendContent("FragmentArchitecture0");
                            }
                        } else {
                            startActivity(new Intent(getActivity(), Activity_LoginSuccess.class));
                        }
//                        if (((MyApplication) getActivity().getApplication()).getLoginSuccessful()) {
//                            startActivity(new Intent(getActivity(), Activity_LoginSuccess.class));
//                        } else {
//                            displayFragment(fragment_mvp, "FragmentArchitecture0");
//                            if (myListener != null) {
//                                myListener.sendContent("FragmentArchitecture0");
//                            }
//                        }
                        break;
                }

            }

            @Override
            public void onItemLongClick(View view, int pisition) {
            }
        });

    }
}
