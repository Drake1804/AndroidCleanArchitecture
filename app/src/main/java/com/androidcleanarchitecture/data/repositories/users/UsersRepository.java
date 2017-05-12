package com.androidcleanarchitecture.data.repositories.users;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.DbService;
import com.androidcleanarchitecture.data.rest.RestService;
import com.androidcleanarchitecture.di.interfaces.data.IUsersRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
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
                .filter(users -> users.size() > 0)
                .subscribeOn(Schedulers.computation());
        Observable<List<User>> usersRest = restService.getUsers()
                .subscribeOn(Schedulers.io())
                .doOnNext(users -> dbService.saveUsers(users))
                .subscribeOn(Schedulers.computation());
        return Observable.concat(usersDb, usersRest);
    }
}
