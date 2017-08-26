package com.example.i.observerpatterndemo.note;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.i.observerpatterndemo.R;
import com.example.i.observerpatterndemo.base.BaseActivityWithLL;

/**
 * Created by I on 2017/8/26.
 */

public class NoteActivity extends BaseActivityWithLL {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NoteFragment noteFragment = new NoteFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container_ll, noteFragment).commit();
    }
}
