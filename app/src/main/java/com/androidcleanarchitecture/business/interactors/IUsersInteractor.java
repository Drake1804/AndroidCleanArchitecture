package com.androidcleanarchitecture.business.interactors;

import com.androidcleanarchitecture.data.models.UserEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */

public interface IUsersInteractor {

    Observable<List<UserEntity>> getUsers();

}
