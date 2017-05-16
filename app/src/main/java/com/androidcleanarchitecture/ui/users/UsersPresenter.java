package com.androidcleanarchitecture.ui.users;

import com.androidcleanarchitecture.R;
import com.androidcleanarchitecture.business.interactors.IUsersInteractor;
import com.androidcleanarchitecture.di.interfaces.ui.IUsersPresenter;
import com.androidcleanarchitecture.utils.Constants;
import com.androidcleanarchitecture.utils.NetworkUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
                .map(users -> {
                    if (!NetworkUtil.isNetworkAvailable(usersView.getContext())) {
                        usersView.showMessage(usersView.getContext().getString(R.string.connect_internet),
                                Constants.LENGTH_LONG);
                    }
                    return users;
                })
                .subscribe(userEntities -> {
                            usersView.showUsers(userEntities);
                            usersView.dismissProgress();
                        },
                        throwable -> {
                            Timber.e(throwable.getMessage());
                            usersView.showError(throwable.getMessage());
                            usersView.dismissProgress();
                        });
        compositeDisposable.add(loadUsersDisposable);
    }
}
