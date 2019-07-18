package com.example.testapp.inject;

import com.example.testapp.MainRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DomainModule.class)
public interface AppComponent {

    void inject(MainRepository mainRepository);
}
