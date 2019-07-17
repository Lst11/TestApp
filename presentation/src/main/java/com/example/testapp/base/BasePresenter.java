package com.example.testapp.base;

public abstract class BasePresenter<R extends BaseRouter, V extends  BaseView> {

    protected R router = null;
    protected V view = null;

    public BasePresenter(V view) {
        this.view = view;
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
