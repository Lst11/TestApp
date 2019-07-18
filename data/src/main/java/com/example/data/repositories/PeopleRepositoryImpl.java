package com.example.data.repositories;

import com.example.domain.entity.Person;
import com.example.domain.repositories.PeopleRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PeopleRepositoryImpl implements PeopleRepository {

    @Inject
    public PeopleRepositoryImpl(){}

    ArrayList<Person> list = PeopleListSingleton.getInstance().list;


    @Override
    public Observable<ArrayList<Person>> getAll() {

        Observable<ArrayList<Person>> observable = Observable.just(list);

        return observable;
    }
}
