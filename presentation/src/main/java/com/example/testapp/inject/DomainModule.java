package com.example.testapp.inject;

import android.content.Context;

import com.example.data.repositories.PeopleRepositoryImpl;
import com.example.domain.executor.PostExecutorThread;
import com.example.domain.repositories.PeopleRepository;
import com.example.testapp.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DomainModule {

    private Context context;

    public DomainModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    PostExecutorThread providePostExecutorThread() {
        return new UIThread();
    }

    @Provides
    @Singleton
    PeopleRepository providePeopleRepository() {
        return new PeopleRepositoryImpl();
    }

}
