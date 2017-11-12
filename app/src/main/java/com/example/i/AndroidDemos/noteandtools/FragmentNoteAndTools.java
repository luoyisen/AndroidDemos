package com.example.i.AndroidDemos.noteandtools;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.ActivityWithWebView;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;
import com.example.i.AndroidDemos.noteandtools.note.ActivityEventDispatch;
import com.example.i.AndroidDemos.noteandtools.note.NoteDialogWithConfig;
import com.example.i.AndroidDemos.noteandtools.tools.FragmentApps;

import java.util.ArrayList;

/***
 * Created by I on 2017/8/26.
 */

public class FragmentNoteAndTools extends BaseFragmentWithRV {
    ArrayList<String> arrayList;
    FragmentApps fragmentApps;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentApps = new FragmentApps();
        arrayList = new ArrayList<>();
        arrayList.add("As快捷键");
        arrayList.add("本机App");
        arrayList.add("Handler");
        arrayList.add("事件分发");
        arrayList.add("多线程");
        arrayList.add("事件分发");
        arrayList.add("事件分发");
        arrayList.add("事件分发");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        NoteDialogWithConfig.Builder customBuilder = new
                                NoteDialogWithConfig.Builder(getActivity());
                        customBuilder.setTitle("Android Studio KeyMap")
                                .setMessage("类的层级关系:CTRL + H\n" +
                                        "删除整行代码:CTRL + X\n" + "最近更改的代码:CTRL + E\n" + "查找文件:CTRL + SHIFT + F\n" + "查找文件:CTRL + SHIFT + N\n" + "JAVA->Kotlin:CTRL + ALT + SHIFT + K\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf")
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();

                                            }
                                        })
                                .setPositiveButton("Confirm",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                .setCancelAble(true);
                        customBuilder.create().show();
                        break;
                    case 1:
                        displayFragment(fragmentApps, "FragmentNoteAndTools1");
                        if (myListener != null) {
                            myListener.sendContent("FragmentNoteAndTools1");
                        }
                        break;
                    case 2:
                        NoteDialogWithConfig.Builder builder = new NoteDialogWithConfig.Builder(getContext());
                        builder.setTitle("Handler使用注意事项")
                                .setMessage("如果内部类的生命周期和Activity的生命周期不一致（比如:Activity finish()之后要等10分钟，内部类的实例才会执行），则在Activity中要避免使用非静态的内部类，这种情况，就使用一个静态内部类，同时持有一个对Activity的WeakReference。")
                                .setCancelAble(true);
                        builder.create().show();
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), ActivityEventDispatch.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), ActivityWithWebView.class));
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {

            }
        });
    }
}
