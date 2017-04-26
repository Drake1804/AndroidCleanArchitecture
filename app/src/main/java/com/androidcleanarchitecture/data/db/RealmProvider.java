package com.androidcleanarchitecture.data.db;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class RealmProvider implements DbProvider<Realm> {

    @Inject
    public RealmProvider() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }


    @Override
    public Realm getDb() {
        return Realm.getDefaultInstance();
    }
}
