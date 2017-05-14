package com.androidcleanarchitecture.business.interactors;

import com.androidcleanarchitecture.business.exceptions.EmptyException;
import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.di.interfaces.data.IUsersRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public class UsersInteractor implements IUsersInteractor {

    private IUsersRepository usersRepository;

    public UsersInteractor(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Observable<List<User>> getUsers() {
        return usersRepository.getUsers().flatMap(users -> users.size() > 0
                ? Observable.just(users)
                : Observable.error(new EmptyException("Empty")));
    }
}
