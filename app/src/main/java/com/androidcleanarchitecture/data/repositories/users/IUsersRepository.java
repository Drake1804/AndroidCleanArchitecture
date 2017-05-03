package com.androidcleanarchitecture.data.repositories.users;

import com.androidcleanarchitecture.data.models.UserEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Pavel.Shkaran on 4/27/2017.
 */

public interface IUsersRepository {

    Observable<List<UserEntity>> getUsers();
}
