package com.androidcleanarchitecture.di.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Pavel.Shkaran on 5/5/2017.
 */
@Module
public class DbModule {

    @Provides
    @Singleton
    Realm providesRealm() {
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);

        return Realm.getDefaultInstance();
    }

}
