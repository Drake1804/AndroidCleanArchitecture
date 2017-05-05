package com.androidcleanarchitecture.di.application;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavel.Shkaran on 5/4/2017.
 */
@Module
public class ApplicationModule {

    private final Context applicationContext;

    public ApplicationModule(@NonNull Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return applicationContext;
    }
}
