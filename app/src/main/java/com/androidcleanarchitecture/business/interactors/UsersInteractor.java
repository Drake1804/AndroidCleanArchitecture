package com.androidcleanarchitecture.business.interactors;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.di.interfaces.data.IUsersRepository;

import java.util.List;

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
        return usersRepository.getUsers();
    }
}
