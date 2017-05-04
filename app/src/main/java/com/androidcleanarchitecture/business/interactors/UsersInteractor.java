package com.androidcleanarchitecture.business.interactors;

import com.androidcleanarchitecture.data.models.UserEntity;
import com.androidcleanarchitecture.data.repositories.users.IUsersRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public class UsersInteractor implements IUsersInteractor {

    private IUsersRepository usersRepository;


    @Override
    public Observable<List<UserEntity>> getUsers() {
        return usersRepository.getUsers();
    }
}
