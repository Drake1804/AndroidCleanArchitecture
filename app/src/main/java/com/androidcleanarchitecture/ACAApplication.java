package com.androidcleanarchitecture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;

import com.androidcleanarchitecture.di.application.ApplicationComponent;
import com.androidcleanarchitecture.di.application.ApplicationModule;
import com.androidcleanarchitecture.di.application.DaggerApplicationComponent;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */

public class ACAApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    @NonNull
    public static ACAApplication get(@NonNull Context context) {
        return (ACAApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
