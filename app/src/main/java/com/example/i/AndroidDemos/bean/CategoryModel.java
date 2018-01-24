package com.example.i.AndroidDemos.bean;

/**
 * Created by I on 2017/8/30.
 */

public class CategoryModel {

    private String name;
    private String cover;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
