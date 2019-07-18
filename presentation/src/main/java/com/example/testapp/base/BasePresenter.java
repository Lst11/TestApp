package com.example.testapp.base;

public abstract class BasePresenter<R extends BaseRouter, V extends BaseView, M extends BaseRepository> {

    protected R router = null;
    protected V view = null;
    protected M repository = null;

    public BasePresenter(V view, M repository) {
        this.view = view;
        this.repository = repository;
    }

    public void addRouter(R router) {
        this.router = router;
    }

    public void removeRouter() {
        this.router = null;
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

}
