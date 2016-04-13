package com.zhe.core.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhe.commons.util.ErrorUtil;
import com.zhe.core.navigation.Navigator;
import com.zhe.core.util.CommonUseCases;
import com.zhe.core.util.LoadAndToast;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

/**
 * Created by zhe on 16/3/10.
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity {

    @Bean
    protected Navigator navigator;

    @Bean
    protected CommonUseCases commonUseCases;

    @Bean
    protected LoadAndToast loadAndToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                handleUncaughtException(thread, e);
            }
        });
    }

    protected void handleUncaughtException(Thread thread, Throwable e) {
        Log.d("Report :: ", e.toString());

        String cause = ErrorUtil.getCause(e);
        String errorType = ErrorUtil.getExceptionType(e);
        String stackTrace = ErrorUtil.getStrackTrace(e);
        String deviceInfo = ErrorUtil.getDeviceInfo();

        Intent i = new Intent(getApplicationContext(), ErrorActivity.class);
        i.putExtra(ErrorActivity.EXCEPTION_TYPE_ARG, errorType);
        i.putExtra(ErrorActivity.STACKTRACE_ARG, stackTrace);
        i.putExtra(ErrorActivity.DEVICE_INFO_ARG, deviceInfo);
        i.putExtra(ErrorActivity.CAUSE_ARG, cause);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigator.setCurrentActivityOnScreen(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigator.setCurrentActivityOnScreen(null);
    }

}
