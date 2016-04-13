package com.sw10k.zhe.views.activities.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.zhe.core.app.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.RootContext;

@EActivity
public abstract class Sw10kBaseActivity extends BaseActivity {

    protected Context context;

    protected Toolbar toolbar;

    protected abstract void initContentView();

    protected abstract void setToolbar();

    @AfterViews
    protected void afterViews() {
        initContentView();
        setToolbar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showToast(String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
}
