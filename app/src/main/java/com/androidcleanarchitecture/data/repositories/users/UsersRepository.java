package com.androidcleanarchitecture.data.repositories.users;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.DbService;
import com.androidcleanarchitecture.data.rest.RestService;
import com.androidcleanarchitecture.data.rest.mapper.UserRestMapper;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Pavel.Shkaran on 4/27/2017.
 */

public class UsersRepository implements IUsersRepository {

    RestService restService;
    DbService dbService;

    public UsersRepository(RestService restService, DbService dbService) {
        this.restService = restService;
        this.dbService = dbService;
    }

    @Override
    public Observable<List<User>> getUsers() {
        return Observable.concat(restService.getUsers().map(UserRestMapper::convert), dbService.getUsers());
    }

}
