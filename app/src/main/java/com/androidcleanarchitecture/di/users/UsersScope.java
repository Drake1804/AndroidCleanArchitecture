package com.androidcleanarchitecture.di.users;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Pavel.Shkaran on 5/4/2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UsersScope {
}
