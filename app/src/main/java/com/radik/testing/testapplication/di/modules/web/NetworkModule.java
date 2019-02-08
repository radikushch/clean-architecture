package com.radik.testing.testapplication.di.modules.web;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.radik.testing.testapplication.data.web.AccountDataService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {BaseUrlModule.class})
public class NetworkModule {

    @Provides
    @Singleton
    public static Retrofit provideRetrofit(String baseUrl,
                                           RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                           GsonConverterFactory gsonConverterFactory) {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    @Singleton
    public static AccountDataService provideAccountDataService(Retrofit retrofit) {
        return retrofit.create(AccountDataService.class);
    }

    @Provides
    @Singleton
    public static RxJava2CallAdapterFactory provideCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public static GsonConverterFactory provideGsonConvertFactory() {
        return GsonConverterFactory.create();
    }
}
