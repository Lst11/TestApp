package com.example.data.repositories;

import com.example.domain.entity.Person;
import com.example.domain.repositories.PeopleRepository;

import java.util.ArrayList;

public class PeopleRepositoryImpl implements PeopleRepository {

    ArrayList<Person> list;

    {
        list = PeopleListSingleton.getInstance().list;
    }

    @Override
    public ArrayList<Person> getAll() {
        return list;
    }
}
