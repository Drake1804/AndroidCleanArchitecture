package com.androidcleanarchitecture.data.db;

import com.androidcleanarchitecture.data.repositories.RealmRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Pavel.Shkaran on 5/4/2017.
 */
@Singleton
public class RealmService extends RealmRepository {


    @Inject
    public RealmService() {
    }
}
