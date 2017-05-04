package com.androidcleanarchitecture.di;

import com.androidcleanarchitecture.ACAApplication;
import com.androidcleanarchitecture.di.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */



@Component(modules = {ApplicationModule.class, NetworkModule.class})
@Singleton
public interface ApplicationComponent {

    void inject(ACAApplication application);

}
