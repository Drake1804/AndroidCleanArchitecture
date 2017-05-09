package com.androidcleanarchitecture.di.users;

import com.androidcleanarchitecture.business.interactors.IUsersInteractor;
import com.androidcleanarchitecture.business.interactors.UsersInteractor;
import com.androidcleanarchitecture.data.db.DbService;
import com.androidcleanarchitecture.data.repositories.users.IUsersRepository;
import com.androidcleanarchitecture.data.repositories.users.UsersRepository;
import com.androidcleanarchitecture.data.rest.RestApi;
import com.androidcleanarchitecture.data.rest.RestService;
import com.androidcleanarchitecture.ui.users.IUsersPresenter;
import com.androidcleanarchitecture.ui.users.UsersPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavel.Shkaran on 5/4/2017.
 */
@Module
public class UsersModule {

    @Provides
    @UsersScope
    IUsersRepository provideIUsersRepository(RestService restService, DbService dbService) {
        return new UsersRepository(restService, dbService);
    }

    @Provides
    @UsersScope
    IUsersInteractor provideIUsersInteractor(IUsersRepository iUsersRepository) {
        return new UsersInteractor(iUsersRepository);
    }

    @Provides
    @UsersScope
    IUsersPresenter provideIUsersPresenter(IUsersInteractor iUsersInteractor) {
        return new UsersPresenter(iUsersInteractor);
    }
}
