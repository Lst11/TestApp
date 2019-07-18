package com.example.testapp;

import android.os.Bundle;

import com.example.testapp.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainPresenter, MainRouter, MainRepository> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

    }

    @Override
    public MainPresenter prodivePresenter() {
        return new MainPresenter(this, prodiveRepository());
    }

    @Override
    public MainRepository prodiveRepository() {
        return new MainRepository();
    }

    @Override
    public MainRouter provideRouter() {
        return new MainRouter(this);
    }

    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showPeople() {
        //TODO: передаем данные
    }
}
