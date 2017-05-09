package com.androidcleanarchitecture.data.db.mapper;

import com.androidcleanarchitecture.business.models.Address;
import com.androidcleanarchitecture.business.models.Company;
import com.androidcleanarchitecture.business.models.Geo;
import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.models.UserEntity;

/**
 * Created by drake1804 on 5/9/17.
 */

public class UserDbMapper {

    private static final String EMPTY_STRING = "";

    public static User mapUser(UserEntity userEntity) {
        return User
                .builder()
                .setId(userEntity.id)
                .setName(userEntity.name == null ? EMPTY_STRING : userEntity.name)
                .setUsername(userEntity.username == null ? EMPTY_STRING : userEntity.username)
                .setEmail(userEntity.email == null ? EMPTY_STRING : userEntity.email)
                .setAddress(userEntity.address == null ? Address.builder().build() : Address
                        .builder()
                        .setStreet(userEntity.address.street == null ? EMPTY_STRING : userEntity.address.street)
                        .setSuite(userEntity.address.suite == null ? EMPTY_STRING : userEntity.address.suite)
                        .setCity(userEntity.address.city == null ? EMPTY_STRING : userEntity.address.city)
                        .setZipcode(userEntity.address.zipcode == null ? EMPTY_STRING : userEntity.address.zipcode)
                        .setGeo(userEntity.address.geo == null ? Geo.builder().build() : Geo.builder()
                                .setLat(userEntity.address.geo.lat)
                                .setLng(userEntity.address.geo.lng)
                                .build())
                        .build())
                .setPhone(userEntity.phone == null ? EMPTY_STRING : userEntity.phone)
                .setWebsite(userEntity.website == null ? EMPTY_STRING : userEntity.website)
                .setCompany(userEntity.company == null ? Company.builder().build() : Company
                        .builder()
                        .setName(userEntity.company.name == null ? EMPTY_STRING : userEntity.company.name)
                        .setBs(userEntity.company.bs == null ? EMPTY_STRING : userEntity.company.bs)
                        .setCatchPhrase(userEntity.company.catchPhrase == null ? EMPTY_STRING : userEntity.company.catchPhrase).build())
                .build();
    }

}
