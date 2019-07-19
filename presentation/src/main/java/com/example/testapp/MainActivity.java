package com.example.testapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

        EditText searchEditText = findViewById(R.id.searchEditText);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchEditText.setOnClickListener(v -> Log.e("aaa", "onNext: " + list.toString()));
                filter(editable.toString());
            }
        });
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

    private void filter(String text) {

        ArrayList<Person> filteredList = new ArrayList<>();
        String textLowerCase = text.toLowerCase();
        for (Person person : list) {
            if (person.getName().toLowerCase().contains(textLowerCase) || person.getSurname().toLowerCase().contains(textLowerCase))
                filteredList.add(person);
        }
        adapter.setList(filteredList);
    }
}
