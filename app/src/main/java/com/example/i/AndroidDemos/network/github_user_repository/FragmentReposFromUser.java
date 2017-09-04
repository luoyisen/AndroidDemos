package com.example.i.AndroidDemos.network.github_user_repository;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.i.AndroidDemos.adapter.BaseLVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithLV;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by I on 2017/9/3.
 */

public class FragmentReposFromUser extends BaseFragmentWithLV {
    ArrayList arrayList;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList = new ArrayList<>();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        GithubApi githubApi = retrofit.create(GithubApi.class);
        Call<List<GithubRepo>> call = githubApi.getRepoFromUser("luoyisen");
        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();
                listView.setAdapter(new BaseLVAdapter(getContext(), repos));
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(getActivity(), "获取仓库失败 :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
