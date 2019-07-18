package com.example.domain.repositories;

import com.example.domain.entity.Person;

import java.util.ArrayList;
import io.reactivex.Observable;

public interface PeopleRepository {

    //TODO: add get and search methods;

    Observable<ArrayList<Person>> getAll();
}
