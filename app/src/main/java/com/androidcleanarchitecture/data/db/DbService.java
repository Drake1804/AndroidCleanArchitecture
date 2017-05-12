package com.androidcleanarchitecture.data.db;

import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.db.mapper.UserDbMapper;
import com.androidcleanarchitecture.data.db.models.UserEntity;
import com.androidcleanarchitecture.data.rest.mapper.UserRestMapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by drake1804 on 5/9/17.
 */

public class DbService {

    public DbService() {
    }

    public Observable<List<User>> getUsers() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<UserEntity> userEntities = realm.where(UserEntity.class).findAll();
        List<User> users = new ArrayList<>();
        users.addAll(convert(userEntities));
        realm.close();

        return Observable.just(users);
    }

    public void saveUsers(List<User> users) {
        Realm realm = Realm.getDefaultInstance();
        RealmList<UserEntity> userEntities = new RealmList<>();
        for(User user : users) {
            userEntities.add(UserRestMapper.mapUserToDb(user));
        }
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(userEntities));
        realm.close();
    }

    private List<User> convert(List<UserEntity> userEntities) {
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            users.add(UserDbMapper.mapUser(userEntity));
        }

        return users;
    }
}
