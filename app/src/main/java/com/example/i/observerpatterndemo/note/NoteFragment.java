package com.example.i.observerpatterndemo.note;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.i.observerpatterndemo.adapter.BaseRVAdapter;
import com.example.i.observerpatterndemo.base.BaseFragmentWithRV;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/26.
 */

public class NoteFragment extends BaseFragmentWithRV {
    ArrayList arrayList;
    public BaseRVAdapter adapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList = new ArrayList<>();
        arrayList.add("As快捷键");
        arrayList.add("a");
        arrayList.add("a");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        NoteDialogConfig.Builder customBuilder = new
                                NoteDialogConfig.Builder(getActivity());
                        customBuilder.setTitle("Android Studio KeyMap")
                                .setMessage("查看类的层级关系:CTRL + H\n" +
                                        "adf查看类的层级关系:\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf\n" + "adf")
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
                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {

            }
        });
    }
}
