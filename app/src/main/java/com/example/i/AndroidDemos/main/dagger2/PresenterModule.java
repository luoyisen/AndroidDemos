package com.example.i.AndroidDemos.main.dagger2;

import com.example.i.AndroidDemos.main.dao.UserDataSource;
import com.example.i.AndroidDemos.main.login.loginPresenter.LoginContract;
import com.example.i.AndroidDemos.main.login.loginPresenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/***
 * Created by I on 2017/9/24.
 */

@Module
public class PresenterModule {
    @Provides
    public LoginContract.Presenter provideLoginPresenter(UserDataSource dataSource) {
        return new LoginPresenter(dataSource);
    }

//    @Provides
//    @DiView
//    public SearchContract.Presenter provideSearchPresenter(RepositoryDataSource repositoryDataSource, UserDataSource userDataSource) {
//        return new SearchPresenter(repositoryDataSource, userDataSource);
//    }

//    @Provides
//    @DiView
//    public ExploreContract.Presenter provideExplorePresenter(ExploreDataSource exploreDataSource, RepositoryDataSource repositoryDataSource,
//                                                             GankDataSource gankDataSource, ArsenalDataSource arsenalDataSource) {
//        return new ExplorePresenter(exploreDataSource, repositoryDataSource, gankDataSource, arsenalDataSource);
//    }
//
//    @Provides
//    public NewsContract.Presenter provideNewsPresenter(UserDataSource userDataSource, Context context) {
//        return new NewsPresenter(userDataSource, context);
//    }
//
//    @Provides
//    public Presenter provideHomePagePresenter(UserDataSource userDataSource, Context ctx) {
//        return new PersonalPagePresenter(userDataSource, ctx);
//    }
//
//    @Provides
//    public ListRepoPresenter provideListRepoPresenter(UserDataSource userDataSource, RepositoryDataSource repositoryDataSource) {
//        return new ListRepoPresenter(userDataSource, repositoryDataSource);
//    }
//
//    @Provides
//    public ListUserPresenter provideListUserPresenter(RepositoryDataSource repositoryDataSource, UserDataSource userDataSource) {
//        return new ListUserPresenter(repositoryDataSource, userDataSource);
//    }
//
//    @Provides
//    public RepoPageContract.Presenter provideRepoPagePresenter(RepositoryDataSource repositoryDataSource) {
//        return new RepoPagePresenter(repositoryDataSource);
//    }
//
//    @Provides
//    public RepoSourceContract.Presenter provideRepoSourcePresenter(RepositoryDataSource repositoryDataSource) {
//        return new RepoSourcePresenter(repositoryDataSource);
//    }
}