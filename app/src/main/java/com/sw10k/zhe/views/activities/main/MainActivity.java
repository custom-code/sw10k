package com.sw10k.zhe.views.activities.main;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.sw10k.zhe.R;
import com.sw10k.zhe.views.activities.base.BaseActivity;
import com.sw10k.zhe.views.activities.test.LoginActivity;
import com.sw10k.zhe.views.activities.weather.WeatherActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.btn_navigation_page)
    Button vBtnNavigationPage;
    @Bind(R.id.btn_weather_page)
    Button vBtnWeatherPage;
    @Bind(R.id.btn_test_page)
    Button vBtnTestPage;

    @Override
    protected void initContentView() {
        context = MainActivity.this;
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        vBtnNavigationPage.setOnClickListener(this);
        vBtnWeatherPage.setOnClickListener(this);
        vBtnTestPage.setOnClickListener(this);
    }

    @Override
    protected void setToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            showToast("Settings");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_navigation_page:
                intent.setClass(context, NavigationDrawerActivity.class);
                break;
            case R.id.btn_weather_page:
                intent.setClass(context, WeatherActivity.class);
                break;
            case R.id.btn_test_page:
                intent.setClass(context, LoginActivity.class);
        }
        startActivity(intent);
    }
}
