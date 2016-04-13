package com.sw10k.zhe.views.activities.test;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;
import com.sw10k.zhe.R;
import com.sw10k.zhe.views.activities.base.Sw10kBaseActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity
public class TestActivity extends Sw10kBaseActivity implements ObservableScrollViewCallbacks {

    private int mParallaxImageHeight = 180;
    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    @ViewById(R.id.imageView)
    ImageView vIvHead;
    @ViewById(R.id.scroll)
    ObservableScrollView vScrollView;

    @Override
    protected void initContentView() {
        setContentView(R.layout.activity_test);

        vScrollView.setScrollViewCallbacks(this);
//        TestObject testObject = new TestObject();
//        testObject.setName("大表哥");
//        testObject.setAddress("上海");
//        testObject.save(context, new SaveListener() {
//            @Override
//            public void onSuccess() {
//                showToast("success");
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                showToast("failure");
//            }
//        });
    }

    @Override
    protected void setToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(vScrollView.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.colorPrimary);
//        int baseColor = toolbar.getSolidColor();
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(vIvHead, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
