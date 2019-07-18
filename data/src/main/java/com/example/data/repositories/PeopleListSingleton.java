package com.example.data.repositories;

import com.example.domain.entity.Person;

import java.util.ArrayList;

public class PeopleListSingleton {

    public ArrayList<Person> list = new ArrayList<Person>() {{
        add(new Person("0", "Peter", "Parker", "48-222-333-111", 19));
        add(new Person("1", "Bruce", "Wayne", "48-111-222-333", 25));
        add(new Person("2", "Tony", "Stark", "48-333-111-222", 37));
        add(new Person("3", "Selina", "Kyle", "48-444-555-000", 24));
        add(new Person("4", "James", "Gordon", "48-000-444-555", 38));
    }};

    private static final PeopleListSingleton ourInstance = new PeopleListSingleton();

    public static PeopleListSingleton getInstance() {
        return ourInstance;
    }
}
