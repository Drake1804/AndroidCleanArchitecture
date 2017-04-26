package com.androidcleanarchitecture.data.models;

import io.realm.RealmObject;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class GeoEntity extends RealmObject {

    public double lat;

    public double lng;

    public GeoEntity() {
    }
}
