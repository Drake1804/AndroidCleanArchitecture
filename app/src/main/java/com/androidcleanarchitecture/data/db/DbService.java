package com.androidcleanarchitecture.data.db;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.mapper.UserDbMapper;
import com.androidcleanarchitecture.data.db.models.UserEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by drake1804 on 5/9/17.
 */

public class DbService {

    Realm realm;

    public DbService(Realm realm) {
        this.realm = realm;
    }

    public Observable<List<User>> getUsers() {
        RealmResults<UserEntity> userEntities = realm.where(UserEntity.class).findAll();
        return Observable.just(convert(userEntities));
    }

    private List<User> convert(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            users.add(UserDbMapper.mapUser(userEntity));
        }

        return users;
    }


}
