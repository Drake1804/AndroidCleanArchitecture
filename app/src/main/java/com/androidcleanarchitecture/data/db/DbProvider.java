package com.androidcleanarchitecture.data.db;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public interface DbProvider<T> {

    T getDb();

}
