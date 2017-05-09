package com.androidcleanarchitecture.data.models.mapper;

import com.androidcleanarchitecture.business.models.Address;
import com.androidcleanarchitecture.business.models.Company;
import com.androidcleanarchitecture.business.models.Geo;
import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.models.AddressEntity;
import com.androidcleanarchitecture.data.models.CompanyEntity;
import com.androidcleanarchitecture.data.models.GeoEntity;
import com.androidcleanarchitecture.data.models.UserEntity;

import javax.inject.Inject;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class UserMapper extends Mapper<User, UserEntity> {

    private static final String EMPTY_STRING = "";


    public UserMapper() {
    }

    @Override
    public User map(UserEntity userDb) {
        if (userDb != null) {
            return User.builder()
                    .setId(userDb.id)
                    .setName(userDb.name == null ? EMPTY_STRING : userDb.name)
                    .setUsername(userDb.username == null ? EMPTY_STRING : userDb.username)
                    .setEmail(userDb.email == null ? EMPTY_STRING : userDb.email)
                    .setAddress(userDb.address == null ? Address.builder()
                            .setStreet(EMPTY_STRING)
                            .setSuite(EMPTY_STRING)
                            .setCity(EMPTY_STRING)
                            .setZipcode(EMPTY_STRING)
                            .setGeo(Geo.builder().setLat(0).setLng(0).build())
                            .build() : mapAddress(userDb.address))
                    .setPhone(userDb.phone == null ? EMPTY_STRING : userDb.phone)
                    .setWebsite(userDb.website == null ? EMPTY_STRING : userDb.website)
                    .setCompany(userDb.company == null ? Company.builder()
                            .setName(EMPTY_STRING)
                            .setCatchPhrase(EMPTY_STRING)
                            .setBs(EMPTY_STRING)
                            .build() : mapCompany(userDb.company))
                    .build();
        }

        return null;
    }

    private Address mapAddress(AddressEntity addressDb) {
        return Address.builder()
                .setStreet(addressDb.street == null ? EMPTY_STRING : addressDb.street)
                .setSuite(addressDb.suite == null ? EMPTY_STRING : addressDb.suite)
                .setCity(addressDb.city == null ? EMPTY_STRING : addressDb.city)
                .setZipcode(addressDb.zipcode == null ? EMPTY_STRING : addressDb.zipcode)
                .setGeo(addressDb.geo == null ? Geo.builder().setLat(0).setLng(0).build() : mapGeo(addressDb.geo))
                .build();
    }

    private Geo mapGeo(GeoEntity geoDb) {
        return Geo.builder()
                .setLat(geoDb.lat)
                .setLat(geoDb.lng)
                .build();
    }

    private Company mapCompany(CompanyEntity companyDb) {
        return Company.builder()
                .setName(companyDb.name == null ? EMPTY_STRING : companyDb.name)
                .setCatchPhrase(companyDb.catchPhrase == null ? EMPTY_STRING : companyDb.catchPhrase)
                .setBs(companyDb.bs == null ? EMPTY_STRING : companyDb.bs)
                .build();
    }
}
