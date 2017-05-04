package com.androidcleanarchitecture.data.repositories;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import io.realm.Realm;

/**
 * Created by Pavel.Shkaran on 5/4/2017.
 */

public class RealmRepository {

    private Lock lock;

    protected RealmRepository() {
        lock = new ReentrantLock();
    }

    public  <T> T execute(Executor<T> executor) {
        Realm realm;
        try {
            lock.lock();
            realm = Realm.getDefaultInstance();
            return executor.execute(realm);
        } finally {
            realm = Realm.getDefaultInstance();
            if (realm != null && !realm.isClosed()) {
                realm.close();
            }
            lock.unlock();
        }
    }

    public interface Executor<T> {
        T execute(Realm realm);
    }

}
