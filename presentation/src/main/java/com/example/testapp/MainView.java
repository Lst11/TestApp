package com.example.testapp;

import com.example.domain.entity.Person;
import com.example.testapp.base.BaseView;

import java.util.ArrayList;

public interface MainView extends BaseView {

    public void showPeople(ArrayList<Person> list);
}
