package com.example.i.AndroidDemos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.bean.CategoryModel;

import java.util.List;

/**
 * Created by I on 2017/8/30.
 */

public class CategoryListAdapter extends BaseAdapter {

    public Context mContext;
    private LayoutInflater inflater;
    private List<CategoryModel> mList;
    private CategoryModel model;

    public CategoryListAdapter(Context mContext, List<CategoryModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.fragment_category_list_item, null);
            viewHolder.iv_category_list_icon = (ImageView) view.findViewById(R.id.iv_category_list_icon);
            viewHolder.tv_category_list_name = (TextView) view.findViewById(R.id.tv_category_list_name);
            view.setTag(viewHolder);// TODO: 2017/9/2
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        model = mList.get(i);
//        Picasso.with(mContext).load(model.getCover()).into(viewHolder.iv_category_list_icon);
        Glide.with(mContext).load(model.getCover()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.iv_category_list_icon);
//        GlideUtils.loadImageCrop(mContext, model.getCover(), viewHolder.iv_category_list_icon);
        viewHolder.tv_category_list_name.setText(model.getName());
        return view;
    }

    class ViewHolder {
        private ImageView iv_category_list_icon;
        private TextView tv_category_list_name;
    }

}
