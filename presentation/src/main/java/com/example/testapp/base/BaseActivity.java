package com.example.testapp.base;

import android.app.Activity;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity extends Activity {

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void addToDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}

