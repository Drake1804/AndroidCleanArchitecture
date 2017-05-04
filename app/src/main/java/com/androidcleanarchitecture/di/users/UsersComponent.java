package com.androidcleanarchitecture.di.users;

import com.androidcleanarchitecture.ui.users.UsersFragment;

import dagger.Subcomponent;

/**
 * Created by Pavel.Shkaran on 5/4/2017.
 */
@Subcomponent(modules = {UsersModule.class})
@UsersScope
public interface UsersComponent {

    void inject(UsersFragment usersFragment);

}
