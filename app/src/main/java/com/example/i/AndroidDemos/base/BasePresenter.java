package com.example.i.AndroidDemos.base;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.main.AccountPrefs;
import com.example.i.AndroidDemos.presentation.presenter.MvpPresenter;
import com.example.i.AndroidDemos.util.Note;
import com.example.i.AndroidDemos.util.Utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/***
 * Created by I on 2017/9/24.
 */

public class BasePresenter<T extends BaseView> implements MvpPresenter<T> {

    private CompositeSubscription subscriptions;
    private T view;

    @Override
    public void attachView(T mvpView) {
        view = mvpView;
        subscriptions = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        view = null;
        if (subscriptions != null) {
            subscriptions.unsubscribe();
            subscriptions = null;
        }
    }

    public T getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public boolean checkLogin() {
        if (AccountPrefs.isLogin(MyApplication.getContext()))
            return true;
        view.showOnError(MyApplication.getContext().getString(R.string.note_to_login));
        return false;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(BaseView) before" + " requesting data to the Presenter");
        }
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public boolean checkNetwork() {
        if (!Utils.isNetworkAvailable(MyApplication.getContext())) {
            Note.show(Utils.getString(R.string.error_no_network));
            return false;
        }
        return true;
    }

    @UpdateType
    private int getUpdateType(int page) {
        return page == 1 ? 401 : 140;
    }

}
