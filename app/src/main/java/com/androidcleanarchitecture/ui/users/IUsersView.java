package com.androidcleanarchitecture.ui.users;

import com.androidcleanarchitecture.business.models.User;

import java.util.List;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public interface IUsersView {

    void showProgress();

    void showError();

    void hideProgress();

    void showUsers(List<User> users);

}
