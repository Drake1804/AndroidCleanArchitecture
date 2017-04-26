package com.androidcleanarchitecture.utils;

import android.support.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Pavel.Shkaran on 4/26/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layout {
    @LayoutRes int id();
}
