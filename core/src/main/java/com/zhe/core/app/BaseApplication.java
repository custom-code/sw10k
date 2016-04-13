package com.zhe.core.app;

import android.app.Application;

import com.zhe.core.database.SnappyDatabase;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

/**
 * Created by zhe on 16/3/12.
 */
@EApplication
public class BaseApplication extends Application {

    @Bean
    protected SnappyDatabase snappyDatabase;
}
