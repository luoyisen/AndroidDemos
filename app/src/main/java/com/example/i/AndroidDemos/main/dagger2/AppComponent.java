package com.example.i.AndroidDemos.main.dagger2;

import android.content.Context;


import com.example.i.AndroidDemos.main.dao.UserDataSource;

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

