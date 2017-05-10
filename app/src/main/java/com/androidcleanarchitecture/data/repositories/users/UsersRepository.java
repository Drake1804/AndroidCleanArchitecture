package com.androidcleanarchitecture.data.repositories.users;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.DbService;
import com.androidcleanarchitecture.data.rest.RestService;

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
        Observable<List<User>> usersDb = dbService.getUsers().subscribeOn(Schedulers.computation());
        Observable<List<User>> usersRest = restService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(users -> {
                    Observable.create(observableEmitter -> {
                        dbService.saveUsers(users);
                        observableEmitter.onComplete();
                    }).subscribe();

                    return users;
                });
        return Observable.concat(usersDb, usersRest);
    }
}
