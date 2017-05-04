package com.androidcleanarchitecture.di.application;

import com.androidcleanarchitecture.data.db.RealmService;
import com.androidcleanarchitecture.data.rest.RestService;
import com.androidcleanarchitecture.di.users.UsersComponent;
import com.androidcleanarchitecture.di.users.UsersModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */


@Component(modules = {ApplicationModule.class})
@Singleton
public interface ApplicationComponent {

    UsersComponent plus(UsersModule usersModule);

    RestService restService();

    RealmService realmService();

}
