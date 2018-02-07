package com.example.i.AndroidDemos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by HHX on 2018/2/7.
 */

public class EasyLVAdapter<T> extends BaseAdapter {
    protected Context mContext;
    private List<T> mList;
    private int[] layoutIds;
    private LayoutInflater mLayoutInflater;

    public EasyLVAdapter(Context mContext, List<T> mList, int... layoutIds) {
        this.mContext = mContext;
        this.mList = mList;
        this.layoutIds = layoutIds;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    public EasyLVAdapter(Context mContext, List<T> mList) {
        this.mContext = mContext;
        this.mList = mList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    private int getLayoutIdForSpecifiedView(int position) {
        int layoutId;
        if (layoutIds == null || layoutIds.length == 0) {
            layoutId = getLayoutId(position, mList.get(position));
        } else {
            layoutId = layoutIds[getLayoutIndex(position, mList.get(position))];
        }
        return layoutId;
    }

    public int getLayoutId(int position, T item) {
        return 0;
    }

    public int getLayoutIndex(int position, T item) {
        return 0;
    }
}
