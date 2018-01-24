package com.example.i.AndroidDemos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.bean.CategoryGridModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by I on 2017/8/30.
 */

public class CategoryDataAdapter extends BaseAdapter {

    public Context mContext;
    private LayoutInflater inflater;
    private List<CategoryGridModel> mList;
    private CategoryGridModel model;

    public CategoryDataAdapter(Context mContext, List<CategoryGridModel> mList) {
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
            view = inflater.inflate(R.layout.fragment_special_item, null);
            viewHolder.iv_main_grid_icon = (ImageView) view.findViewById(R.id.iv_main_grid_icon);
            viewHolder.tv_main_grid_number = (TextView) view.findViewById(R.id.tv_main_grid_number);
            viewHolder.ll_item_download = (LinearLayout) view.findViewById(R.id.ll_item_download);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        model = mList.get(i);
        Picasso.with(mContext)
                .load(model.getBig())
                .into(viewHolder.iv_main_grid_icon);
//        GlideUtils.loadImageCrop(mContext, model.getBig(), viewHolder.iv_main_grid_icon);
        viewHolder.tv_main_grid_number.setText(model.getDown() + "");
        viewHolder.ll_item_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "onClick:" + model.getDown(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    class ViewHolder {
        private ImageView iv_main_grid_icon;
        private TextView tv_main_grid_number;
        private LinearLayout ll_item_download;
    }

}
