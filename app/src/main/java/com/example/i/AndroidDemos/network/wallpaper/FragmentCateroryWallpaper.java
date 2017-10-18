package com.example.i.AndroidDemos.network.wallpaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.service.ApiLoveWallpaper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by I on 2017/8/30.
 */

public class FragmentCateroryWallpaper extends Fragment {

    private ApiLoveWallpaper apiLoveWallpaper;
    private ListView mListView;
    private CategoryListAdapter mCategoryListAdapter;
    private List<CategoryModel> mList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.mListView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), CategoryActivity.class);
                intent.putExtra("name", mList.get(i).getName());
                intent.putExtra("url", mList.get(i).getUrl());
                startActivity(intent);
            }
        });
        /**
         * retrofit使用步骤：
         * 要点：1.describe the endpoints. 2.what they expect 3. what they respond
         * (1).创建一个接口进行HTTP请求描述 (ApiLoveWallpaper)
         * (2).创建
         * (2).使用Retrofit.Builder构建模式构造出来一个Retrofit实例
         * (3).因为要调用定义的接口中的具体方法，所以要创建一个实例(Create an implementation of the API endpoints defined by the {@code service} interface).
         * (4).调用接口中的具体方法，返回值是call<call方法的类型>
         * (5).
         */

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open.lovebizhi.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        apiLoveWallpaper = retrofit.create(ApiLoveWallpaper.class);
        Call<WallpaperApiModel> call = apiLoveWallpaper.getWallpaperApi();
        //请求数据
        call.enqueue(new Callback<WallpaperApiModel>() {
            @Override
            public void onResponse(Call<WallpaperApiModel> call, Response<WallpaperApiModel> response) {
                if (response.isSuccessful()) {
                    parsingJson(response.body().getCategory());
                }
            }

            @Override
            public void onFailure(Call<WallpaperApiModel> call, Throwable t) {
                Toast.makeText(getActivity(), "数据获取失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //解析
    private void parsingJson(List<WallpaperApiModel.CategoryBean> category) {
        for (int i = 0; i < category.size(); i++) {
            CategoryModel model = new CategoryModel();
            model.setName(category.get(i).getName());
            model.setCover(category.get(i).getCover());
            model.setUrl(category.get(i).getUrl());
            mList.add(model);
        }
        mCategoryListAdapter = new CategoryListAdapter(getActivity(), mList);
        mListView.setAdapter(mCategoryListAdapter);
    }
}

