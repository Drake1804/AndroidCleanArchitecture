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
}
