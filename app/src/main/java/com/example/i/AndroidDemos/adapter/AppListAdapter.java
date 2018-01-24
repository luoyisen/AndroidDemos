package com.example.i.AndroidDemos.adapter;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.bean.AppInfo;

import java.util.List;

/***
 * Created by I on 2017/8/27.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private List<AppInfo> appInfoList;

    public AppListAdapter(List<AppInfo> appInfoList) {
        this.appInfoList = appInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appinfo, parent, false);
        return new ViewHolder(rootView);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setBackground(appInfoList.get(position).getAppIcon());
        holder.textView.setText(appInfoList.get(position).getAppName());
    }

    @Override
    public int getItemCount() {
        return appInfoList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.appicon);
            textView = (TextView) itemView.findViewById(R.id.appname);
        }
    }
}

