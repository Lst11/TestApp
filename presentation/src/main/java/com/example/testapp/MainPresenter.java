package com.example.testapp;

import com.example.domain.entity.Person;
import com.example.testapp.base.BasePresenter;

import java.util.ArrayList;

public class MainPresenter extends BasePresenter<MainRouter, MainView, MainRepository> {

    MainPresenter(MainView view, MainRepository repository) {
        super(view, repository);
    }

    @Override
    public void onStart() {
        super.onStart();
        ArrayList<Person> list = repository.getAll();
        view.showPeople(list);
    }
}
