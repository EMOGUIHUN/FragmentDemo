package com.app.zym.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/9.
 */

public class Fragment1 extends Fragment {
    private TabLayout tobTop;
    private ViewPager mPager;
    private FragmentPagerAdapter mAdapter;

    private List<Fragment> listFragment;
    private List<String> listTitle;

    private FragmentEmotion fragmentNew;
    private FragmentEmotion fragmentPopular;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tobTop = (TabLayout) view.findViewById(R.id.tab_emotion_title);
        mPager = (ViewPager) view.findViewById(R.id.vp_emotion_pager);
        init();
        return view;
    }
    private void init(){
        listFragment = new ArrayList<>();
        fragmentNew = FragmentEmotion.newInstance("0");
        listFragment.add(fragmentNew);

        fragmentPopular = FragmentEmotion.newInstance("1");
        listFragment.add(fragmentPopular);

        listTitle = new ArrayList<>();
        listTitle.add("最新");
        listTitle.add("最热门");

        tobTop.setTabMode(TabLayout.MODE_FIXED);


        tobTop.addTab(tobTop.newTab().setText(listTitle.get(0)));
        tobTop.addTab(tobTop.newTab().setText(listTitle.get(1)));

        mAdapter = new TabLayoutAdapter(getActivity().getFragmentManager(),listFragment,listTitle);

        mPager.setAdapter(mAdapter);

        tobTop.setupWithViewPager(mPager);
    }
}
