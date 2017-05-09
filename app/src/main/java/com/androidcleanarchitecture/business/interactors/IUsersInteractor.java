package com.androidcleanarchitecture.business.interactors;

import com.androidcleanarchitecture.business.models.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public interface IUsersInteractor {

    Observable<List<User>> getUsers();

}
