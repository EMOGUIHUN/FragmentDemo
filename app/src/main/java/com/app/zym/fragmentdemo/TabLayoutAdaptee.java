package com.app.zym.fragmentdemo;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;


/**
 * Created by Administrator on 2016/12/21.
 */

public class TabLayoutAdaptee extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;
    private List<String>   list_title;
    public TabLayoutAdaptee(FragmentManager fm,List<Fragment> list_fragment, List<String>   list_title) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list_title = list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment==null?0:list_fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position);
    }
}
