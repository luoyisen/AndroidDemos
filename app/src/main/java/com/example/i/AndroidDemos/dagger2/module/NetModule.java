package com.example.i.AndroidDemos.dagger2.module;

import android.content.Context;

import com.example.i.AndroidDemos.constant.bean.UserDataSource;
import com.example.i.AndroidDemos.main.login.network.GithubAuthRetrofit;
import com.example.i.AndroidDemos.main.login.network.GithubCommonRetrofit;
import com.example.i.AndroidDemos.main.login.network.GithubOkHttpClient;
import com.example.i.AndroidDemos.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/***
 * Created by I on 2017/9/24.
 */
@Module
public class NetModule {
    @Provides
    @Singleton
    public GithubCommonRetrofit provideGithubCommonRetrofit(GithubOkHttpClient client) {
        return new GithubCommonRetrofit(client);
    }

    @Provides
    public GithubAuthRetrofit provideGithubAuthRetrofit() {
        return new GithubAuthRetrofit();
    }

//    @Provides
//    public GithubExploreRetrofit provideGithubExploreRetrofit(CacheOkHttpClient client) {
//        return new GithubExploreRetrofit(client);
//    }

//    @Provides
//    public GankRetrofit provideGankExploreRetrofit(CacheOkHttpClient client) {
//        return new GankRetrofit(client);
//    }

//    @Provides
//    public ArsenalRetrofit provideArsenalRetrofit(CacheOkHttpClient client) {
//        return new ArsenalRetrofit(client);
//    }

//    @Provides
//    public ExploreService provideExploreService(GithubExploreRetrofit githubExploreRetrofit) {
//        return githubExploreRetrofit.build().create(ExploreService.class);
//    }

//    @Provides
//    public GankService provideGankService(GankRetrofit gankRetrofit) {
//        return gankRetrofit.build().create(GankService.class);
//    }

//    @Provides
//    public ArsenalService provideArsenalService(ArsenalRetrofit arsenalRetrofit) {
//        return arsenalRetrofit.build().create(ArsenalService.class);
//    }

//    @Provides
//    public RepositoryService provideRepositoryService(GithubCommonRetrofit githubCommonRetrofit) {
//        return githubCommonRetrofit.build().create(RepositoryService.class);
//    }

    @Provides
    public UserService provideUserService(GithubCommonRetrofit githubCommonRetrofit) {
        return githubCommonRetrofit.build().create(UserService.class);
    }

    @Provides
    @Singleton
    public UserDataSource provideUserDataSource(GithubAuthRetrofit authRetrofit, UserService userApi, Context ctx) {
        return new UserDataSource(authRetrofit, userApi, ctx);
    }

//    @Provides
//    @Singleton
//    public RepositoryDataSource provideRepositoryDataSource(RepositoryService repositoryApi) {
//        return new RepositoryDataSource(repositoryApi);
//    }

//    @Provides
//    @Singleton
//    public ExploreDataSource provideExploreDataSource(ExploreService exploreApi) {
//        return new ExploreDataSource(exploreApi);
//    }

//    @Provides
//    @Singleton
//    public GankDataSource provideGankDataSource(GankService gankService, RepositoryService repositoryService) {
//        return new GankDataSource(gankService, repositoryService);
//    }

//    @Provides
//    @Singleton
//    public ArsenalDataSource provideArsenalDataSource(ArsenalService arsenalService, RepositoryService repositoryService) {
//        return new ArsenalDataSource(arsenalService, repositoryService);
//    }

}