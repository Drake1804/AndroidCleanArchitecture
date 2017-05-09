package com.androidcleanarchitecture.data.rest.mapper;

import com.androidcleanarchitecture.business.models.Address;
import com.androidcleanarchitecture.business.models.Company;
import com.androidcleanarchitecture.business.models.Geo;
import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.mapper.UserDbMapper;
import com.androidcleanarchitecture.data.db.models.UserEntity;
import com.androidcleanarchitecture.data.rest.models.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drake1804 on 5/9/17.
 */

public class UserRestMapper {
    private static final String EMPTY_STRING = "";

    public static User mapUser(UserModel userEntity) {
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

    public static List<User> convert(List<UserModel> userEntities) {
        List<User> users = new ArrayList<>();
        for (UserModel userEntity : userEntities) {
            users.add(UserRestMapper.mapUser(userEntity));
        }

        return users;
    }
}
