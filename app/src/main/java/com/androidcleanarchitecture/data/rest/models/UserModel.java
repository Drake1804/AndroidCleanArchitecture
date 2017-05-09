package com.androidcleanarchitecture.data.rest.models;

import io.realm.annotations.PrimaryKey;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class UserModel {

    @PrimaryKey
    public short id;

    public String name;

    public String username;

    public String email;

    public AddressModel address;

    public String phone;

    public String website;

    public CompanyModel company;

    public UserModel() {
    }

    public UserModel(short id, String name, String username, String email, AddressModel address, String phone, String website, CompanyModel company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
}
