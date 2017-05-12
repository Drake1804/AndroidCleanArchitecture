package com.androidcleanarchitecture.di.interfaces.ui;

import com.androidcleanarchitecture.ui.users.IUsersView;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public interface IUsersPresenter {

    void bindView(IUsersView usersView);

    void unbindView();

    void loadUsers();
}
