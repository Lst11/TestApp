package com.example.testapp;

import com.example.domain.entity.Person;
import com.example.domain.usecases.GetPeopleUseCase;
import com.example.testapp.app.App;
import com.example.testapp.base.BaseRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainRepository implements BaseRepository {

    @Inject
    GetPeopleUseCase getPeopleUseCase;

    {
        App.appComponent.inject(this);
    }

    public Observable<ArrayList<Person>> getAll() {
        return getPeopleUseCase.getAll();
    }
}