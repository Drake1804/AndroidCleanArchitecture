package com.androidcleanarchitecture.ui.users;

import com.androidcleanarchitecture.business.interactors.IUsersInteractor;
import com.androidcleanarchitecture.utils.RetryWithDelay;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userEntities -> usersView.showUsers(userEntities),
                        throwable -> Timber.e(throwable.getMessage()));
        compositeDisposable.add(loadUsersDisposable);
    }
}
