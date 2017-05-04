package com.androidcleanarchitecture.ui.users;

import com.androidcleanarchitecture.business.interactors.IUsersInteractor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public class UsersPresenter implements IUsersPresenter {

    private IUsersInteractor usersInteractor;
    private IUsersView usersView;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public UsersPresenter(IUsersInteractor usersInteractor) {
        this.usersInteractor = usersInteractor;
    }

    @Override
    public void bindView(IUsersView usersView) {
        this.usersView = usersView;
    }

    @Override
    public void unbindView() {
        compositeDisposable.clear();
        usersView = null;
    }

    @Override
    public void loadUsers() {
        usersView.showProgress();
        Disposable loadUsersDisposable = usersInteractor.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userEntities -> {

                });
        compositeDisposable.add(loadUsersDisposable);

    }
}
