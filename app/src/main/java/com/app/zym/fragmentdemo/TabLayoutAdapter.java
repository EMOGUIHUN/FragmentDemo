package com.app.zym.fragmentdemo;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;


import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_Fragment;
    private List<String >  list_Title;
    public TabLayoutAdapter(FragmentManager fm, List<Fragment> list_Fragment,List<String> list_Title) {
        super(fm);
        this.list_Fragment = list_Fragment;
        this.list_Title = list_Title;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return list_Fragment.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list_Fragment==null?0:list_Fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position);
    }
}
