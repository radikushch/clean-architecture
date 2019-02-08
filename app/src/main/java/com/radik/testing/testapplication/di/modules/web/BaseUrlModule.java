package com.radik.testing.testapplication.di.modules.web;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseUrlModule {

    @Provides
    @Singleton
    public static String provideBaseUrl() {
        return "http://demo1655807.mockable.io";
    }
}
