package com.androidcleanarchitecture.data.repositories.users;

import com.androidcleanarchitecture.data.models.UserEntity;
import com.androidcleanarchitecture.data.rest.RestService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Pavel.Shkaran on 4/27/2017.
 */

public class UsersRepository implements IUsersRepository {

    @Inject
    RestService restService;

    @Override
    public Observable<List<UserEntity>> getUsers() {
        // get data from db or rest
        return restService.getUsers();
    }
}
