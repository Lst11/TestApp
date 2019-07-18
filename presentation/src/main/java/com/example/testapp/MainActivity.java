package com.example.testapp;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entity.Person;
import com.example.testapp.base.BaseMvpActivity;

import java.util.ArrayList;

public class MainActivity extends BaseMvpActivity<MainPresenter, MainRouter, MainRepository> implements MainView {

    private RecyclerView recyclerView = null;
    private RecyclerViewAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecyclerView();
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
    public void showPeople(ArrayList<Person> list) {
        adapter.setList(list);
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(this.getBaseContext());
        recyclerView.setAdapter(adapter);
    }
}
