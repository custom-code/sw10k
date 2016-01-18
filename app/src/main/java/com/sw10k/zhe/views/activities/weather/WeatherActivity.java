package com.sw10k.zhe.views.activities.weather;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sw10k.zhe.R;
import com.sw10k.zhe.views.activities.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WeatherActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void initContentView() {
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
    }

    @Override
    protected void setToolbar() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("aaa");
            }
        });
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

}
