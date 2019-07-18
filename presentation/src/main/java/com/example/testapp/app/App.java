package com.example.testapp.app;

import android.app.Application;

import com.example.testapp.inject.AppComponent;
import com.example.testapp.inject.DaggerAppComponent;
import com.example.testapp.inject.DomainModule;

public class App extends Application {

    private App instance;
    public static AppComponent appComponent;

    {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .domainModule(new DomainModule(this))
                .build();
    }
}
