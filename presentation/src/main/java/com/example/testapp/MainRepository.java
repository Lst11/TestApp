package com.example.testapp;

import android.util.Log;

import com.example.domain.entity.Person;
import com.example.domain.usecases.GetPeopleUseCase;
import com.example.testapp.app.App;
import com.example.testapp.base.BaseRepository;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainRepository implements BaseRepository {

    @Inject
    GetPeopleUseCase getPeopleUseCase;

    {
        App.appComponent.inject(this);
    }


    public void getAll() {
        ArrayList<Person> list = getPeopleUseCase.getAll();
        for (Person person : list) {
            Log.e("aaa", person.toString());
        }

    }
}