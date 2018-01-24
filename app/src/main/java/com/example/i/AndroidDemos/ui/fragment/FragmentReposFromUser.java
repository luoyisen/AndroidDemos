package com.example.i.AndroidDemos.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.i.AndroidDemos.adapter.BaseLVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithLV;
import com.example.i.AndroidDemos.service.GithubApi;
import com.example.i.AndroidDemos.bean.GithubRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***
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
        Call<List<GithubRepository>> call = githubApi.getReposFromUser("luoyisen");
        call.enqueue(new Callback<List<GithubRepository>>() {
            @Override
            public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
                List<GithubRepository> repos = response.body();
                listView.setAdapter(new BaseLVAdapter(getActivity(), repos));
            }

            @Override
            public void onFailure(Call<List<GithubRepository>> call, Throwable t) {
                Toast.makeText(getActivity(), "获取仓库失败 :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
