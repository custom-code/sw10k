package com.sw10k.zhe.views.activities.weather;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sw10k.zhe.R;
import com.sw10k.zhe.views.activities.base.Sw10kBaseActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_weather)
public class WeatherActivity extends Sw10kBaseActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void initContentView() {

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
