package com.radik.testing.testapplication.di.modules.contexts;

import android.content.Context;

import com.radik.testing.testapplication.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Context context;

    public ApplicationContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @Provides
    public Context provideContext() {
        return context;
    }
}
