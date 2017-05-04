package com.androidcleanarchitecture.di.application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.content.Context;
import android.support.annotation.NonNull;

import com.androidcleanarchitecture.BuildConfig;
import com.androidcleanarchitecture.data.db.RealmService;
import com.androidcleanarchitecture.data.rest.RestService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pavel.Shkaran on 5/4/2017.
 */
@Module
public class ApplicationModule {

    private final Context applicationContext;
    private final static String BASE_URL = "https://jsonplaceholder.typicode.com";

    public ApplicationModule(@NonNull Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return applicationContext;
    }

    @Provides
    @Singleton
    RealmService providesRealmService() {
        return new RealmService();
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient;
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ?
                        HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .build();

        return okHttpClient;
    }

    @Singleton
    @Provides
    RestService provideRestService(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(RestService.class);
    }
}
