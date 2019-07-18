package com.example.testapp;

import com.example.domain.entity.Person;
import com.example.testapp.base.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface MainView extends BaseView {

    void showPeople(Observable<ArrayList<Person>> observableList);
}
