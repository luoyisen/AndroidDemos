package com.example.i.AndroidDemos.noteandtools;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseActivityWithLL;

/**
 * Created by I on 2017/8/26.
 */

public class ActivityNoteAndTools extends BaseActivityWithLL {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentNoteAndTools fragmentNoteAndTools = new FragmentNoteAndTools();
        getSupportFragmentManager().beginTransaction().add(R.id.container_ll, fragmentNoteAndTools, "fragment_root").commit();
    }
}
