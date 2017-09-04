package com.example.i.AndroidDemos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.network.github_user_repository.GithubRepo;

import java.util.List;

/**
 * Created by I on 2017/9/3.
 */

public class BaseLVAdapter extends BaseAdapter {
    private Context context;
    private List<GithubRepo> githubRepos;

    public BaseLVAdapter(Context context, List<GithubRepo> githubRepos) {
        this.context = context;
        this.githubRepos = githubRepos;
    }

    @Override
    public int getCount() {
        return githubRepos.size();
    }

    @Override
    public Object getItem(int position) {
        return githubRepos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_base_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.repoName = (TextView) view.findViewById(R.id.textreponames);
            viewHolder.repoCreateTime = (TextView) view.findViewById(R.id.textrepocreatetime);
            viewHolder.repoSize = (TextView) view.findViewById(R.id.textreposize);
            viewHolder.repoUpdateTime = (TextView) view.findViewById(R.id.textrepoupdatetime);
            view.setTag(viewHolder);// TODO: 2017/9/3  toun
        } else {
            viewHolder = (ViewHolder) view.getTag();// TODO: 2017/9/3 toun
        }
        viewHolder.repoName.setText(githubRepos.get(position).getName());
        viewHolder.repoCreateTime.setText(githubRepos.get(position).getCreated_at());
        viewHolder.repoUpdateTime.setText(githubRepos.get(position).getPushed_at());
        viewHolder.repoSize.setText((Integer.parseInt(githubRepos.get(position).getSize()) ) + "kb");
        return view;

    }

    static class ViewHolder {
        TextView repoName;
        TextView repoCreateTime;
        TextView repoUpdateTime;
        TextView repoSize;
    }

}
