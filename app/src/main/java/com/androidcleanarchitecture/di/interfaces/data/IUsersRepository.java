package com.androidcleanarchitecture.di.interfaces.data;

import com.androidcleanarchitecture.business.models.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Pavel.Shkaran on 4/27/2017.
 */

public interface IUsersRepository {

    Observable<List<User>> getUsers();
}
