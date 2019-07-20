package com.example.data.repositories;

import android.util.Log;

import com.example.domain.entity.Person;
import com.example.domain.repositories.PeopleRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PeopleRepositoryImpl implements PeopleRepository {

    @Inject
    public PeopleRepositoryImpl() {
    }

    ArrayList<Person> list = PeopleListSingleton.getInstance().list;


    @Override
    public Observable<ArrayList<Person>> getAll() {

        Observable<ArrayList<Person>> observable = Observable.just(list);

        return observable;
    }

    @Override
    public Observable<ArrayList<Person>> getAllByName() {


        ArrayList<Person> list = PeopleListSingleton.getInstance().list;


        boolean isSorted = false;
        Person temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                String name1 = list.get(i).getName();
                String name2 = list.get(i + 1).getName();
                if (name1.compareToIgnoreCase(name2) > 0) {
                    isSorted = false;
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
        Log.e("aaa", "getAllByName: " + list.toString());


        return Observable.just(list);
    }

    @Override
    public Observable<ArrayList<Person>> getAllBySurname() {
        ArrayList<Person> list = PeopleListSingleton.getInstance().list;


        boolean isSorted = false;
        Person temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                String surname1 = list.get(i).getSurname();
                String surname2 = list.get(i + 1).getSurname();
                if (surname1.compareToIgnoreCase(surname2) > 0) {
                    isSorted = false;
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
        Log.e("aaa", "getAllBySurname: " + list.toString());


        return Observable.just(list);
    }

    @Override
    public Observable<ArrayList<Person>> getAllByAge() {

        ArrayList<Person> list = PeopleListSingleton.getInstance().list;


        boolean isSorted = false;
        Person temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                int age1 = list.get(i).getAge();
                int age2 = list.get(i + 1).getAge();
                if (age1 > age2) {
                    isSorted = false;
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
        Log.e("aaa", "getAllByAge: " + list.toString());

        return Observable.just(list);
    }
}
