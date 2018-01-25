package com.example.i.AndroidDemos.service;

import com.example.i.AndroidDemos.constant.bean.WallpaperApiModel;

import retrofit2.Call;
import retrofit2.http.GET;

/***
 * Created by I on 2017/8/30.
 */

public interface ApiLoveWallpaper {

    //获取爱壁纸接口
    @GET("baidu_rom.php")
    Call<WallpaperApiModel> getWallpaperApi();//call方法

}
