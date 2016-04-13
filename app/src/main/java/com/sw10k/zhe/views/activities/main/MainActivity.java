package com.sw10k.zhe.views.activities.main;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sw10k.zhe.R;
import com.sw10k.zhe.views.activities.base.Sw10kBaseActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.app_bar_menu)
public class MainActivity extends Sw10kBaseActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    @ViewById(R.id.btn_navigation_page)
    Button vBtnNavigationPage;
    @ViewById(R.id.btn_weather_page)
    Button vBtnWeatherPage;
    @ViewById(R.id.btn_test_page)
    Button vBtnTestPage;

    @Override
    protected void initContentView() {
        vBtnNavigationPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
            }
        });
    }

    @Override
    protected void setToolbar() {

    }


}
