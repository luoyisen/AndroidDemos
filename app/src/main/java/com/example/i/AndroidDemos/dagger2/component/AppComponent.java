package com.example.i.AndroidDemos.dagger2.component;

import android.content.Context;


import com.example.i.AndroidDemos.constant.bean.UserDataSource;
import com.example.i.AndroidDemos.dagger2.module.ContextModule;
import com.example.i.AndroidDemos.dagger2.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/***
 * Created by I on 2017/9/24.
 */

@Singleton
@Component(modules = {NetModule.class, ContextModule.class})
public interface AppComponent {
    Context CONTEXT();

//    ExploreDataSource exploreDataSource();

//    RepositoryDataSource repositoryDataSource();

    UserDataSource userDataSource();

//    GankDataSource gankDataSource();

//    ArsenalDataSource arsenalDataSource();
}
