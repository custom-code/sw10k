package com.sw10k.zhe.sw10k;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sw10k.zhe.sw10k.fragment.PlaceholderFragment;
import com.sw10k.zhe.sw10k.fragment.PlusOneFragment;

import java.util.List;

/**
 * Created by zhe on 15/11/13.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public SectionsPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
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
}
