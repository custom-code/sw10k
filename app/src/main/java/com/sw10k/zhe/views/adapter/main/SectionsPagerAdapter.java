package com.sw10k.zhe.views.adapter.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sw10k.zhe.R;
import com.sw10k.zhe.views.fragments.main.OneFragment;
import com.sw10k.zhe.views.fragments.main.ThreeFragment;
import com.sw10k.zhe.views.fragments.main.TwoFragment;

/**
 * Created by zhe on 15/11/13.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT = 3;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return OneFragment.newInstance("", "");
            case 2:
                return TwoFragment.newInstance("", "");
            default:
                return ThreeFragment.newInstance(2);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "1";
//            case 1:
//                return "2";
//            case 2:
//                return "3";
//        }
        return null;
    }


    public int getTabImageId(int position) {
        Integer[] imageResId = new Integer[]{
                R.drawable.ic_person_24dp,
                R.drawable.ic_notifications_24dp,
                R.drawable.ic_favorite_24dp};
        return imageResId[position];
    }
}
