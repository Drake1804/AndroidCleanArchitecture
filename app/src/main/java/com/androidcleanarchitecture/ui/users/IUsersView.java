package com.androidcleanarchitecture.ui.users;

import android.content.Context;

import com.androidcleanarchitecture.business.models.User;

import java.util.List;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public interface IUsersView {

    void showProgress();

    void showError(String text);

    void dismissProgress();

    void showUsers(List<User> users);

    Context getContext();

    void showMessage(String message, int length);

}
