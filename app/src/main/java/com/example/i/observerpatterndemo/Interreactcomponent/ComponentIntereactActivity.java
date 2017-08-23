package com.example.i.observerpatterndemo.Interreactcomponent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.i.observerpatterndemo.R;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/23.
 */

public class ComponentIntereactActivity extends AppCompatActivity {
    private ArrayList arrayList;
    private RecyclerView recyclerview_interreact;
    private InterreactAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_componentintereactactivity);
        recyclerview_interreact = (RecyclerView) findViewById(R.id.recyclerview_interreact);
        arrayList = new ArrayList();
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        arrayList.add("接口实现Fragment和Activity通信");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        arrayList.add("C");
        adapter = new InterreactAdapter(arrayList);
        recyclerview_interreact.setLayoutManager(mLayoutManager);//必须设置
        recyclerview_interreact.setAdapter(adapter);
        recyclerview_interreact.addItemDecoration(new InterreactDecoration(this, LinearLayoutManager.VERTICAL));
        adapter.setOnItemClickListener(new InterreactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }

            @Override
            public void onItemLongClick(View view, int pisition) {
                Toast.makeText(ComponentIntereactActivity.this, "lll", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
