package com.androidcleanarchitecture.di.application;

import android.content.Context;

import com.androidcleanarchitecture.ACAApplication;
import com.androidcleanarchitecture.data.db.DbService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Pavel.Shkaran on 5/5/2017.
 */
@Module
class DbModule {

    @Provides
    @Singleton
    Realm providesRealm(Context context) {
        Realm.init(context);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);

        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    DbService providesDbService(Realm realm) {
        return new DbService(realm);
    }

}
