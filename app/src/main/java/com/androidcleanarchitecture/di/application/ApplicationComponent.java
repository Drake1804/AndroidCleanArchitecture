package com.androidcleanarchitecture.di.application;

import com.androidcleanarchitecture.ACAApplication;
import com.androidcleanarchitecture.di.NetworkModule;
import com.androidcleanarchitecture.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pavel.Shkaran on 5/3/2017.
 */


@Singleton
@Component(modules = {NetworkModule.class})

public interface ApplicationComponent {

    void inject(ACAApplication application);

    void inject(MainActivity mainActivity);

}
