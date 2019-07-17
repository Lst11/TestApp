package com.example.testapp.base;

import android.os.Bundle;

public abstract class BaseMvpActivity<P extends BasePresenter, R extends BaseRouter> extends BaseActivity {

    P presenter;
    R router;

    public abstract P prodivePresenter();

    public abstract R provideRouter();

    public abstract int provideLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        presenter = prodivePresenter();
        router = provideRouter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.addRouter(router);
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.removeRouter();
        presenter.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
