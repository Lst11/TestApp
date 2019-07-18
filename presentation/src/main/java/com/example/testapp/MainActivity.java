package com.example.testapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entity.Person;
import com.example.testapp.base.BaseMvpActivity;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseMvpActivity<MainPresenter, MainRouter, MainRepository> implements MainView {

    private RecyclerView recyclerView = null;
    private RecyclerViewAdapter adapter = null;
    private ArrayList<Person> list = new ArrayList<>();

    Observer<ArrayList<Person>> observer = new Observer<ArrayList<Person>>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e("aaa", "onSubscribe: ");
            addToDisposable(d);
        }

        @Override
        public void onNext(ArrayList<Person> arrayFromObserwable) {
            Log.e("aaa", "onNext: " + arrayFromObserwable.toString());
            list = arrayFromObserwable;
            adapter.setList(list);
        }

        @Override
        public void onError(Throwable e) {
            Log.e("aaa", "onError: " + e.getMessage());
        }

        @Override
        public void onComplete() {
            Log.e("aaa", "onComplete: ");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecyclerView();

        EditText searchEditText= (EditText) findViewById(R.id.searchEditText);
        searchEditText.setOnClickListener(v -> Log.e("aaa", "onNext: " + list.toString()));

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
    public void showPeople(Observable<ArrayList<Person>> observableList) {
        observableList.subscribe(observer);
        adapter.setList(list);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(this.getBaseContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
