package com.example.i.AndroidDemos.datastructure.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i.AndroidDemos.R;
import com.zzhoujay.richtext.RichText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * Created by I on 2017/10/27.
 */

public class FragmentHashMap extends Fragment {
    @BindView(R.id.about)
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hashmap, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        textView.setCompoundDrawablePadding(10);//设置图片和text之间的间距
//        textView.setPadding();
        Map<String, String> map = new HashMap<>();
        map.put("3dpager1", "3dpager1");
        Toast.makeText(getActivity(), map.get("3dpager1"), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.about)
    public void clickabout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.fork)
                .setTitle("HashMap")
                .setMessage("HashMap是一个")
                .create()
                .show();
        RichText.from("fadsfa", 3)
                .autoPlay(true)
                .into(textView)
                .notify();
    }
}
