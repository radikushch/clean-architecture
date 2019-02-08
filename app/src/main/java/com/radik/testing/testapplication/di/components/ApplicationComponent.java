package com.radik.testing.testapplication.di.components;

import android.content.Context;

import com.radik.testing.testapplication.data.web.AccountDataService;
import com.radik.testing.testapplication.di.modules.contexts.ApplicationContextModule;
import com.radik.testing.testapplication.di.modules.web.NetworkModule;
import com.radik.testing.testapplication.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationContextModule.class, NetworkModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    AccountDataService getAccountDataService();

}
