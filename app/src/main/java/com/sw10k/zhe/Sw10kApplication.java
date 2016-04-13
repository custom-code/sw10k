package com.sw10k.zhe;

import com.zhe.core.app.BaseApplication;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EApplication;

import cn.bmob.v3.Bmob;

/**
 * Created by zhe on 16/1/13.
 */
@EApplication
public class Sw10kApplication extends BaseApplication {
    private String mBmobAppId = "dd31e36acd7d10aea47114e06492e2c3";

    @AfterInject
    void onAfterInjectFinished() {
//        Bmob.initialize(this, mBmobAppId);
    }

}
