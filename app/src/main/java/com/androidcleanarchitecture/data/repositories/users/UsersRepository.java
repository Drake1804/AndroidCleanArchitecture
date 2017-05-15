package com.androidcleanarchitecture.data.repositories.users;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.DbService;
import com.androidcleanarchitecture.data.db.models.UserEntity;
import com.androidcleanarchitecture.data.rest.RestService;
import com.androidcleanarchitecture.data.rest.mapper.UserRestMapper;
import com.androidcleanarchitecture.data.rest.models.UserModel;
import com.androidcleanarchitecture.di.interfaces.data.IUsersRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Pavel.Shkaran on 4/27/2017.
 */

public class UsersRepository implements IUsersRepository {

    private RestService restService;
    private DbService dbService;

    public UsersRepository(RestService restService, DbService dbService) {
        this.restService = restService;
        this.dbService = dbService;
    }

    @Override
    public Observable<List<User>> getUsers() {
        Observable<List<User>> usersDb = dbService.getUsers()
                .subscribeOn(Schedulers.computation());

        Observable<List<User>> usersRest = restService.getUsers()
                .onErrorReturn(throwable -> new ArrayList<>())
                .filter(userModels -> userModels.size() > 0)
                .subscribeOn(Schedulers.io())
                .map(UserRestMapper::convert)
                .doOnNext(users -> dbService.saveUsers(users))
                .subscribeOn(Schedulers.computation());

        return Observable.concat(usersDb, usersRest);
    }
}
