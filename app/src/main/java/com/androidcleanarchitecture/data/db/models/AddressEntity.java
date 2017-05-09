package com.androidcleanarchitecture.data.db.models;

import io.realm.RealmObject;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class AddressEntity extends RealmObject {

    public String street;

    public String suite;

    public String city;

    public String zipcode;

    public GeoEntity geo;

    public AddressEntity() {
    }
}
