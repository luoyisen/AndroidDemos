package com.example.i.AndroidDemos.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by commi on 2018/1/21.
 */

public abstract class BaseDialogFragment extends DialogFragment {
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        final Window window = getDialog().getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.875);
        layoutParams.height = layoutParams.width * 3 / 4;
        window.setAttributes(layoutParams);
//        window.setDimAmount(1.0f);
        super.onStart();

    }

    public abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder == null) return;
        unbinder.unbind();
    }
}
