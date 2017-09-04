package com.example.i.AndroidDemos.network.github_user_repository;

/**
 * Created by I on 2017/9/3.
 */

public class GithubRepo {
    private String name;
    private String created_at;
    private String pushed_at;
    private String size;

    public String getPushed_at() {
        return pushed_at;
    }

    public String getSize() {
        return size;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getName() {
        return name;
    }
}
