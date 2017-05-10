package com.androidcleanarchitecture.data.db.models;

import io.realm.RealmObject;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class GeoEntity extends RealmObject {

    public double lat;

    public double lng;

    public GeoEntity() {
    }

    public GeoEntity(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
