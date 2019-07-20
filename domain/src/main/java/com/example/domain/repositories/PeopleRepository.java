package com.example.domain.repositories;

import com.example.domain.entity.Person;

import java.util.ArrayList;
import io.reactivex.Observable;

public interface PeopleRepository {

    Observable<ArrayList<Person>> getAll();
    Observable<ArrayList<Person>> getAllByName();
    Observable<ArrayList<Person>> getAllBySurname();
    Observable<ArrayList<Person>> getAllByAge();
}
