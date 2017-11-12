package com.example.i.AndroidDemos.noteandtools.tools;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.i.AndroidDemos.Interreactcomponent.InterreactDecoration;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.adapter.AppListAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/***
 * Created by I on 2017/8/27.
 */

public class FragmentApps extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<AppInfo> appInfoList;
    private AppListAdapter mAppListAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    public RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_appinfo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appInfoList = new ArrayList<>();
        mAppListAdapter = new AppListAdapter(appInfoList);
        RecyclerView recyclerView = view.findViewById(R.id.rv_basefragment);
        swipeRefreshLayout = view.findViewById(R.id.pull_down_refresh);

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);//必须设置
        recyclerView.addItemDecoration(new InterreactDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAppListAdapter);
        loadApp();


        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }

    @Override
    public void onRefresh() {
        if (appInfoList != null) {
            appInfoList.clear();
            mAppListAdapter.notifyDataSetChanged();
        }
        loadApp();
    }

    private void loadApp() {
        final PackageManager packageManager = getActivity().getPackageManager();
        Observable.create(new Observable.OnSubscribe<ApplicationInfo>() {
            @Override
            public void call(Subscriber<? super ApplicationInfo> subscriber) {
                List<ApplicationInfo> appInfoList = getApplicationInfoList(packageManager);
                for (ApplicationInfo info : appInfoList) {
                    subscriber.onNext(info);
                }
                subscriber.onCompleted();
            }
        }).filter(new Func1<ApplicationInfo, Boolean>() {
            @Override
            public Boolean call(ApplicationInfo applicationInfo) {
                return (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0;//过滤掉系统应用，如果设置为">0"就是过滤掉非系统应用
            }
        }).map(new Func1<ApplicationInfo, AppInfo>() {
            @Override
            public AppInfo call(ApplicationInfo applicationInfo) {
                AppInfo info = new AppInfo();
                info.setAppIcon(applicationInfo.loadIcon(packageManager));
                info.setAppName(applicationInfo.loadLabel(packageManager).toString());
                return info;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AppInfo>() {
                    @Override
                    public void onCompleted() {
                        mAppListAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onNext(AppInfo appInfo) {
                        appInfoList.add(appInfo);
                    }
                });

    }

    private List<ApplicationInfo> getApplicationInfoList(PackageManager packageManager) {
        return packageManager.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
    }

}
