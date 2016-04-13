package com.zhe.core.error;

import android.content.Context;
import android.util.Log;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import com.zhe.commons.util.ErrorUtil;
import com.zhe.core.navigation.Navigator;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

/**
 * Created by zhe on 16/3/10.
 */
@EBean
public class ErrorHandler {

    @RootContext
    protected Context context;

    @Bean
    protected Navigator navigator;

    protected Integer snackBarBackgroundColor;

    public Integer getSnackBarBackgroundColor() {
        return snackBarBackgroundColor;
    }

    public void setSnackBarBackgroundColor(Integer snackBarBackgroundColor) {
        this.snackBarBackgroundColor = snackBarBackgroundColor;
    }

    public void handlerError(Exception e) {
        logError(e);
    }

    @UiThread
    protected void showError(String s) {
        if (navigator.isInForeground()) {
            Snackbar errorSnack;
            if (snackBarBackgroundColor != null) {
                errorSnack = Snackbar.with(context)
                        .text(s)
                        .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                        .color(snackBarBackgroundColor);
            } else {
                errorSnack = Snackbar.with(context)
                        .text(s)
                        .duration(Snackbar.SnackbarDuration.LENGTH_SHORT);
            }

            SnackbarManager.show(errorSnack, navigator.getCurrentActivityOnScreen());
        }
    }

    protected void logError(Throwable e) {
        String report = ErrorUtil.getErrorReport(e);
        Log.e("ErrorHandler Report:", report);
    }


}
