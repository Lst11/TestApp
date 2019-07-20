package com.example.testapp;

import com.example.domain.entity.Person;
import com.example.domain.usecases.GetPeopleByAgeUseCase;
import com.example.domain.usecases.GetPeopleByNameUseCase;
import com.example.domain.usecases.GetPeopleBySurnameUseCase;
import com.example.domain.usecases.GetPeopleUseCase;
import com.example.testapp.app.App;
import com.example.testapp.base.BaseRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainRepository implements BaseRepository {

    @Inject
    GetPeopleUseCase getPeopleUseCase;

    @Inject
    GetPeopleByNameUseCase getPeopleByNameUseCase;

    @Inject
    GetPeopleBySurnameUseCase getPeopleBySurnameUseCase;

    @Inject
    GetPeopleByAgeUseCase getPeopleByAgeUseCase;


    {
        App.appComponent.inject(this);
    }

    public Observable<ArrayList<Person>> getAll() {
        return getPeopleUseCase.getAll();
    }

    public Observable<ArrayList<Person>> getAllByName() {
        return getPeopleByNameUseCase.getAll();
    }

    public Observable<ArrayList<Person>> getAllBySurname() {
        return getPeopleBySurnameUseCase.getAll();
    }

    public Observable<ArrayList<Person>> getAllByAge() {
        return getPeopleByAgeUseCase.getAll();
    }

}