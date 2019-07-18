package com.example.testapp;

import com.example.testapp.app.App;
import com.example.testapp.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainRouter, MainView, MainRepository> {

    MainPresenter(MainView view, MainRepository repository) {
        super(view, repository);
    }

    @Override
    public void onStart() {
        super.onStart();
        repository.getAll();
        view.showPeople();
    }
}
