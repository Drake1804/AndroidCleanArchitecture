package com.androidcleanarchitecture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;

import com.androidcleanarchitecture.di.application.ApplicationComponent;
import com.androidcleanarchitecture.di.application.ApplicationModule;
import com.androidcleanarchitecture.di.application.DaggerApplicationComponent;
import com.androidcleanarchitecture.di.users.UsersComponent;
import com.androidcleanarchitecture.di.users.UsersModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class ACAApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;
    private UsersComponent usersComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        initRealm();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @NonNull
    public static ACAApplication get(@NonNull Context context) {
        return (ACAApplication) context.getApplicationContext();
    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    public UsersComponent plusUsersComponent() {
        if(usersComponent == null) {
            usersComponent = applicationComponent.plusUsersComponent(new UsersModule());
        }

        return usersComponent;
    }
}
