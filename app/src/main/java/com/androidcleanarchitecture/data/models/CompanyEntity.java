package com.androidcleanarchitecture.data.models;

import io.realm.RealmObject;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class CompanyEntity extends RealmObject {

    public String name;

    public String catchPhrase;

    public String bs;

    public CompanyEntity() {
    }
}
