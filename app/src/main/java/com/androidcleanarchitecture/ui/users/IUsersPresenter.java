package com.androidcleanarchitecture.ui.users;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public interface IUsersPresenter {

    void bindView(IUsersView usersView);

    void unbindView();

    void loadUsers();
}
