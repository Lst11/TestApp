package com.example.testapp.base;

import android.content.Context;
import android.widget.Toast;

public abstract class BaseRouter {
    private final BaseActivity activity;

    public BaseRouter(BaseActivity activity) {
        this.activity = activity;
    }

    public final void goBack() {
        this.activity.onBackPressed();
    }

    public void showError(Throwable e) {
        Toast.makeText((Context) this.activity, (CharSequence) ("Error " + e.toString()), 0);
    }
}
