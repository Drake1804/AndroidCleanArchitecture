package com.androidcleanarchitecture.di.application;

import com.androidcleanarchitecture.data.rest.RestApi;
import com.androidcleanarchitecture.data.rest.RestService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.androidcleanarchitecture.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pavel.Shkaran on 5/5/2017.
 */
@Module
class NetworkModule {

    private final static String BASE_URL = "https://jsonplaceholder.typicode.com";

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
    RestApi provideRestApi(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(RestApi.class);
    }

    @Singleton
    @Provides
    RestService provideRestService(RestApi restApi) {
        return new RestService(restApi);
    }
}
