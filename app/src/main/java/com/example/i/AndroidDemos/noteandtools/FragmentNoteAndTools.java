package com.example.i.AndroidDemos.noteandtools;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;
import com.example.i.AndroidDemos.noteandtools.note.NoteDialogWithConfig;
import com.example.i.AndroidDemos.noteandtools.tools.FragmentApps;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 */

public class FragmentNoteAndTools extends BaseFragmentWithRV {
    ArrayList arrayList;
    FragmentApps fragmentApps;

    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentApps = new FragmentApps();
        arrayList = new ArrayList<>();
        arrayList.add("As快捷键");
        arrayList.add("本机App");
        arrayList.add("a");
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
                                .setMessage("查看类的层级关系:CTRL + H\n" +
                                        "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf")
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
                        Log.e("-----", "FragmentNoteAndTools1");

                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {

            }
        });
    }
}
