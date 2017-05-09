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
}
