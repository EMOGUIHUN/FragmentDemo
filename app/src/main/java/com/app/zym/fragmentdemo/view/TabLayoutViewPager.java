package com.app.zym.fragmentdemo.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/1/6.
 */

public class TabLayoutViewPager extends LinearLayout  {
    public TabLayoutViewPager(Context context) {
        super(context);
    }

    public TabLayoutViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabLayoutViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

   /* public TabLayoutViewPager(Context context) {
        super(context);
    }

    public TabLayoutViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabLayoutViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    private Activity context;
    private Map<String, String> topItems;
    private Map<String, Fragment> tabList;
    private FragmentManager fm;
    public TabLayoutViewPager(Activity context, FragmentManager fm, Map<String, String> topItems, Map<String, Fragment> tabList){
        this(context);
        this.setOrientation(VERTICAL);
        this.context = context;
        this.topItems = topItems;
        this.tabList = tabList;
        this.fm = fm;
        initTopItem();
        initTablayout();
    }
    ImageView iv;
    ImageView ivTmp;
    private Map<String, ImageView> topItemImg;
    private void initTopItem(){
        int topI = 0;
        topItemImg = new HashMap<>();
        for (final Map.Entry<String, String> entry : topItems.entrySet()) {
            final RelativeLayout rl = new RelativeLayout(context);
            rl.setBackgroundColor(Color.WHITE);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ConvertUtils.dp2px(60));
            final TextView tv = new TextView(context);
            tv.setText(entry.getKey());
            tv.setTag(entry.getValue());
            tv.setTextColor(Color.BLACK);
            RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            tvParams.addRule(RelativeLayout.CENTER_VERTICAL);//addRule参数对应
            tvParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            tvParams.setMargins(ConvertUtils.dp2px(10), 0, 0, 0);
            rl.addView(tv, tvParams);
            iv = new ImageView(context);
            topItemImg.put(entry.getKey(), iv);
            iv.setImageResource(R.mipmap.configfiels_selected);
            if(topI != 0){
                iv.setVisibility(GONE);
            }
            TextView textView = new TextView(context);
            textView.setBackgroundColor(Color.GRAY);
            RelativeLayout.LayoutParams tvP = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ConvertUtils.dp2px(1));
            tvP.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            rl.addView(textView,tvP);
            RelativeLayout.LayoutParams ivParams = new RelativeLayout.LayoutParams(ConvertUtils.dp2px(20), ConvertUtils.dp2px(20));
            ivParams.addRule(RelativeLayout.CENTER_VERTICAL);
            ivParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            ivParams.setMargins(0, 0, ConvertUtils.dp2px(10), 0);
            rl.addView(iv, ivParams);
            rl.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tc.specifyCB(entry.getKey());
                    for (Map.Entry<String, ImageView> entry : topItemImg.entrySet()){
                        ivTmp = entry.getValue();
                        if(!tv.getText().toString().equals(entry.getKey())){
                            ivTmp.setVisibility(GONE);
                        }else {
                            ivTmp.setVisibility(VISIBLE);
                        }
                    }
                    //设置回调
                }
            });
            this.addView(rl, params);
            topI++;
        }
    }
    private void initTablayout(){
        TabLayout tabLayout;
        ViewPager viewPager;
        FragmentStatePagerAdapter mAdapter;
        List<Fragment> listFragment = new ArrayList<>();
        List<String>   listTitle = new ArrayList<>();
        for (Map.Entry<String, Fragment> entry : tabList.entrySet()){
            listTitle.add(entry.getKey());
            listFragment.add(entry.getValue());
        }
        LinearLayout linearLayoutView = (LinearLayout) ConvertUtils.xmlToView(context,R.layout.tablayout);
        tabLayout = (TabLayout) linearLayoutView.findViewById(R.id.tab_layout);

        viewPager = new ViewPager(context);
        @android.support.annotation.IdRes int id = MathTools.randomNumber(10000, 99999);
        viewPager.setId(id);
        LayoutParams viewPagerP = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        linearLayoutView.addView(viewPager, viewPagerP);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setBackgroundColor(Color.WHITE);
        mAdapter = new TabLayoutAdapter(fm,listFragment,listTitle);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        this.addView(linearLayoutView);
    }
    public void initImg(){
        for (Map.Entry<String, ImageView> entry : topItemImg.entrySet()){
            ivTmp = entry.getValue();
            if(ivTmp.equals(entry.getValue())){
                ivTmp.setVisibility(GONE);
            }
        }
    }
    private TabLayoutViewPager.TabCallback tc;
    public interface TabCallback{
        void specifyCB(String str);
    }
    public void setCallback(TabLayoutViewPager.TabCallback tc){
        this.tc = tc;
    }*/
}
