package com.example.i.AndroidDemos.service;


import com.example.i.AndroidDemos.constant.bean.GithubRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/***
 * Created by I on 2017/9/20.
 */

public interface GithubApi {
    @GET("/users/{user}/repos")//这里大括号里面的user将会被下面传入的参数user替换
    Call<List<GithubRepository>> getReposFromUser(@Path("user") String user);
}