package com.example.i.AndroidDemos.network.wallpaper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by I on 2017/8/30.
 */

public interface ApiImp {

    //获取爱壁纸接口
    @GET("baidu_rom.php")
    Call<WallpaperApiModel> getWallpaperApi();//call方法

}
