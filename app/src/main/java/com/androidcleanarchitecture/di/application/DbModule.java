package com.androidcleanarchitecture.di.application;

import com.androidcleanarchitecture.data.db.DbService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavel.Shkaran on 5/5/2017.
 */
@Module
class DbModule {

    @Provides
    @Singleton
    DbService providesDbService() {
        return new DbService();
    }

}
