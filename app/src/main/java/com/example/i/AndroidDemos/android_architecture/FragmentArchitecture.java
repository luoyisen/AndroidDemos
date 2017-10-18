package com.example.i.AndroidDemos.android_architecture;

import android.app.AlertDialog;
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
import com.example.i.AndroidDemos.customizedview.customizedview.DrawTextView;

import java.util.ArrayList;

import static com.example.i.AndroidDemos.MyApplication.IS_LOGIN_SUCCESS;
import static com.example.i.AndroidDemos.MyApplication.LOGIN_STATE;

/***
 * Created by I on 2017/9/1.
 */

public class FragmentArchitecture extends BaseFragmentWithRV {
    private boolean alreadyExpanded = false;
    ArrayList<String> arrayList;
    Fragment_Mvp fragment_mvp;
    String[] list_javadesignpattern;
    DrawTextView drawTextView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment_mvp = new Fragment_Mvp();
        arrayList = new ArrayList<>();
        list_javadesignpattern = new String[]{"建造者模式"
                , "建造者模式"
                , "建造者模式"
                , "建造者模式"
                , "建造者模式"
                , "建造者模式"
                , "适配器模式"
                , "抽象工厂模式"
                , "工厂模式"
                , "单例模式"
        };
        arrayList.add("MVP:login");
        arrayList.add("MVP:todo");
        arrayList.add("MVP:dagger2_retrofit");
        arrayList.add("JAVA设计模式");
        arrayList.add("MVVM");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(LOGIN_STATE, Context.MODE_PRIVATE);
                        if (sharedPreferences.getBoolean(IS_LOGIN_SUCCESS, false)) {
                            startActivity(new Intent(getActivity(), Activity_LoginSuccess.class));
                        } else {
                            displayFragment(fragment_mvp, "FragmentArchitecture0");
                            if (myListener != null) {
                                myListener.sendContent("FragmentArchitecture0");
                            }
                        }
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        if (alreadyExpanded) {
                            removeDesignPatternItems();
                        } else
                            addDesignPatternItems();
                        break;
                    case 4:
                        if (alreadyExpanded) {
                            drawTextView = new DrawTextView(getActivity());
                            drawTextView.setText("set 和 list的区别 \n" +
                                    "activity生命周期 \n" +
                                    "单利的两种实现模式 \n" +
                                    "判断是不是平衡二叉树 \n" +
                                    "\n" +
                                    "\n" +
                                    "\n" +
                                    "设计一个app，没5秒向服务器发送数据，保证稳定性和可靠性 \n" +
                                    "值传递和引用传递 ");
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setCancelable(true);
                            builder.setView(drawTextView).show();
//                            DialogShowCodeView.Builder builder1 = new DialogShowCodeView.Builder(getActivity());
//                            builder1.setTitle("fdaaaaaa").setSpecifiedView(0);
//                            builder1.setLayoutResID(R.layout.fragment_layout);
//                            builder1.create().show();
                            break;
                        } else {
                        }
                        break;
                    case 5:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                    case 6:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                    case 7:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                    case 8:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                    case 9:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                    case 10:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                    case 11:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                    case 12:
                        if (alreadyExpanded) {
                        } else {
                        }
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {
            }
        });
    }

    public void addDesignPatternItems() {
        for (String aStringList_SortAlgorithm : list_javadesignpattern) {
            arrayList.add(4, aStringList_SortAlgorithm);
            adapter.notifyItemInserted(4);
        }
        rv_base_fragment.scrollToPosition(0);
        alreadyExpanded = true;
    }

    public void removeDesignPatternItems() {
        int i = 0;
        if (arrayList.size() >= 10) {
            while (i < 10) {
                arrayList.remove(4);
                adapter.notifyItemRemoved(4);
                i++;
            }
            alreadyExpanded = false;
        }
    }
}
