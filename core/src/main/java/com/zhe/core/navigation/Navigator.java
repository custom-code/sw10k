package com.zhe.core.navigation;

import android.content.Context;

import com.zhe.core.app.BaseActivity;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by zhe on 16/3/10.
 */
@EBean(scope = EBean.Scope.Singleton)
public class Navigator {

    @RootContext
    Context context;

    private BaseActivity currentActivityOnScreen;

    public BaseActivity getCurrentActivityOnScreen() {
        return currentActivityOnScreen;
    }

    public void setCurrentActivityOnScreen(BaseActivity currentActivityOnScreen) {
        this.currentActivityOnScreen = currentActivityOnScreen;
    }

    public static void navigatorUp(BaseActivity activity) {
        activity.finish();
    }

    public boolean isInForeground() {
        if (currentActivityOnScreen != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
