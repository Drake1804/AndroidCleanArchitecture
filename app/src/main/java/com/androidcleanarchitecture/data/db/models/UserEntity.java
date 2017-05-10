package com.androidcleanarchitecture.data.db.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class UserEntity extends RealmObject {

    @PrimaryKey
    public short id;

    public String name;

    public String username;

    public String email;

    public AddressEntity address;

    public String phone;

    public String website;

    public CompanyEntity company;

    public long createdAt;

    public UserEntity() {
    }

    public UserEntity(short id, String name, String username, String email, AddressEntity address,
                      String phone, String website, CompanyEntity company, long createdAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
        this.createdAt = createdAt;
    }
}
