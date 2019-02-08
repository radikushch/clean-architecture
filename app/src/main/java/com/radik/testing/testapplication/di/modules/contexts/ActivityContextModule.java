package com.radik.testing.testapplication.di.modules.contexts;

import android.content.Context;

import com.radik.testing.testapplication.di.scopes.ActivityContext;
import com.radik.testing.testapplication.presentation.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityContextModule {

    private Context context;

    public ActivityContextModule(MainActivity mainActivity) {
        this.context = mainActivity;
    }

    @ActivityContext
    @Provides
    public Context provideContext() {
        return context;
    }
}
