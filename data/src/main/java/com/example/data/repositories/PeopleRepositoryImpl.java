package com.example.data.repositories;

import android.util.Log;

import com.example.domain.entity.Person;
import com.example.domain.repositories.PeopleRepository;

import java.util.ArrayList;

import javax.inject.Inject;

public class PeopleRepositoryImpl implements PeopleRepository {

    @Inject
    public PeopleRepositoryImpl(){}

    ArrayList<Person> list = PeopleListSingleton.getInstance().list;


    @Override
    public ArrayList<Person> getAll() {
        Log.e("aaa", list.toString());
        return list;
    }
}
