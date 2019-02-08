package com.radik.testing.testapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.radik.testing.testapplication.di.components.ApplicationComponent;
import com.radik.testing.testapplication.di.components.DaggerApplicationComponent;
import com.radik.testing.testapplication.di.modules.contexts.ApplicationContextModule;

public class MyApp extends Application {

    private ApplicationComponent component;
    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
    }

    public ApplicationComponent getComponent() {
        if(component != null) return component;
        component = DaggerApplicationComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();
        return component;
    }

    public static MyApp get() {
        return app;
    }
}
