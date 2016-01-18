package com.sw10k.zhe.views.activities.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;
    protected Toolbar toolbar;

    protected abstract void initContentView();

    protected abstract void setToolbar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = BaseActivity.this;
        initContentView();
        setToolbar();
    }

    protected void showToast(String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
}
