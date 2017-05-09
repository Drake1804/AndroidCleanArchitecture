package com.androidcleanarchitecture.data.rest.models;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class AddressModel {

    public String street;

    public String suite;

    public String city;

    public String zipcode;

    public GeoModel geo;

    public AddressModel() {
    }

    public AddressModel(String street, String suite, String city, String zipcode, GeoModel geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
}
