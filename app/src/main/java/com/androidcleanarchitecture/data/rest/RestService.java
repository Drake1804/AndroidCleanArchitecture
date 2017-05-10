package com.androidcleanarchitecture.data.rest;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.rest.mapper.UserRestMapper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by drake1804 on 5/9/17.
 */

public class RestService {

    private RestApi restApi;

    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<List<User>> getUsers() {
        return restApi.getUsers()
                .subscribeOn(Schedulers.io())
                .filter(userModels -> userModels.size() > 0)
                .map(UserRestMapper::convert);
    }

}
