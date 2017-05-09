package com.androidcleanarchitecture.data.rest;

import com.androidcleanarchitecture.data.rest.models.UserModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public interface RestApi {

    @GET("/users")
    Observable<List<UserModel>> getUsers();
}
