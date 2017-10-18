package com.example.i.AndroidDemos.main.search;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.i.AndroidDemos.main.base.BaseView;
import com.example.i.AndroidDemos.main.search.searchPresenter.IRepoListPresenter;
import com.example.i.AndroidDemos.main.search.searchPresenter.IUserListPresenter;
import com.example.i.AndroidDemos.main.search.searchPresenter.MvpPresenter;
import com.example.i.AndroidDemos.model.RepositoryInfo;

import java.util.List;

/***
 * Created by I on 2017/9/24.
 */

public interface SearchContract {

    interface View extends BaseView {
        void onGetRepos(int total_count, List<RepositoryInfo> items, int updateType);

//        void showListRefreshLoading(@ListType int listType);
//
//        void showOnError(String msg, @ListType int type, int updateType);
    }

    interface Presenter extends MvpPresenter<View>, IRepoListPresenter, IUserListPresenter {

//        void setCurrentSearchEntity(SearchEntity currentSearchEntity);

//        SearchEntity getCurrentSearchEntity();
//
//        SearchEntity getRepoSearchEntity();
//
//        SearchEntity getUserSearchEntity();

        void initialSearch();

        void searchCurrent(boolean fromSearchView, int page);

        void searchRepo(int page);

        void searchUser(int page);

        MaterialDialog getDialogLang();

        MaterialDialog getDialogSortRepo();

        MaterialDialog getDialogSortUser();
    }

//    interface OnListFragmentInteractListener {
//        void onFetchPage(@ListType int type, int page);
//
//        Presenter getPresenter();
//    }
//
//    interface OnGetReposListener extends ListLoadingListener {
//        void onGetRepos(int total_count, List<RepositoryInfo> items, @FooterLoadMoreAdapterWrapper.UpdateType int updateType);
//    }
//
//    interface OnGetUserListener extends ListLoadingListener {
//
//        void onGetUser(int total_count, List<UserEntity> items, @FooterLoadMoreAdapterWrapper.UpdateType int updateType);
//    }
//
//    class SearchEntity {
//        public SearchEntity(@ListType int type) {
//            this.type = type;
//        }
//
//        public boolean isFlying;
//        public int type;
//        public String keyWord;
//        public SortType sortType;
//        public String language;
//        @FooterLoadMoreAdapterWrapper.UpdateType
//        public int updateType;
//    }
}
