package com.androidcleanarchitecture.data.rest.models;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class GeoModel {

    public double lat;

    public double lng;

    public GeoModel() {
    }

    public GeoModel(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
