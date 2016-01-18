package com.sw10k.zhe;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by zhe on 16/1/13.
 */
public class Sw10kApplication extends Application {
    private String mBmobAppId = "dd31e36acd7d10aea47114e06492e2c3";

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, mBmobAppId);
    }

}
