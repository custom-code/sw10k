package com.zhe.core.mvp;

/**
 * Created by zhe on 16/3/10.
 */
public interface Presenter {

    void setView(View view);

    void start();

    void stop();

    void onError(Exception exception);
}
