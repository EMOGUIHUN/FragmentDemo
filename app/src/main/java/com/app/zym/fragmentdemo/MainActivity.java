package com.app.zym.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment0 f0;
    private Fragment1 f1;
    private Fragment2 f2;
    private Fragment3 f3;
    private Fragment4 f4;

    private FragmentTransaction ft;
    private FragmentManager fm;

    private LinearLayout ll0, ll1, ll2, ll3, ll4;

    private ImageButton ibtn0,ibtn1,ibtn2,ibtn3,ibtn4;

    private TextView tvToolbarTitle;

    private int selectPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll0 = (LinearLayout) findViewById(R.id.ll_one);
        ll1 = (LinearLayout) findViewById(R.id.ll_two);
        ll2 = (LinearLayout) findViewById(R.id.ll_three);
        ll3 = (LinearLayout) findViewById(R.id.ll_four);
        ll4 = (LinearLayout) findViewById(R.id.ll_five);

        ibtn0 = (ImageButton) findViewById(R.id.ib_one);
        ibtn1 = (ImageButton) findViewById(R.id.ib_two);
        ibtn2 = (ImageButton) findViewById(R.id.ib_three);
        ibtn3 = (ImageButton) findViewById(R.id.ib_four);
        ibtn4 = (ImageButton) findViewById(R.id.ib_five);

        tvToolbarTitle = (TextView) findViewById(R.id.tv_toolbar_title);

        initEvent();
        selectItem(selectPosition);
    }

    /****
     * 设置事件
     */
    private void initEvent(){
        ll0.setOnClickListener(this);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_one:
                selectPosition = 0;
                selectItem(selectPosition);
                break;
            case R.id.ll_two:
                selectPosition = 1;
                selectItem(selectPosition);
                break;
            case R.id.ll_three:
                selectPosition = 2;
                selectItem(selectPosition);
                break;
            case R.id.ll_four:
                selectPosition = 3;
                selectItem(selectPosition);
                break;
            case R.id.ll_five:
                selectPosition = 4;
                selectItem(selectPosition);
                break;
        }
    }

    /****
     * 点击变换图片
     * @param position
     */
    private void selectItem(int position){
        resetImg();
        fm = getFragmentManager();
        ft = fm.beginTransaction();  //开启事务
        hideFragment(ft);
        switch (position){
            case 0:
                ibtn0.setImageResource(R.mipmap.app_bottom_one_selected);
                tvToolbarTitle.setText("首页");
                if (f0 == null) {
                    f0 = new Fragment0();           //创建Fragment
                    ft.add(R.id.fl_frame, f0);      //添加Fragment 到布局
                }else {
                    ft.show(f0);                    //显示Fragment
                }
                break;
            case 1:
                ibtn1.setImageResource(R.mipmap.app_bottom_two_selected);
                tvToolbarTitle.setText("情感");
                if (f1 == null) {
                    f1 = new Fragment1();
                    ft.add(R.id.fl_frame, f1);
                }else {
                    ft.show(f1);
                }
                break;
            case 2:
                ibtn2.setImageResource(R.mipmap.app_bottom_three_selected);
                tvToolbarTitle.setText("消息");
                if (f2 == null) {
                    f2 = new Fragment2();
                    ft.add(R.id.fl_frame, f2);
                }else {
                    ft.show(f2);
                }
                break;
            case 3:
                ibtn3.setImageResource(R.mipmap.app_bottom_four_selected);
                tvToolbarTitle.setText("附近");
                if (f3 == null) {
                    f3 = new Fragment3();
                    ft.add(R.id.fl_frame, f3);
                }else {
                    ft.show(f3);
                }
                break;
            case 4:
                ibtn4.setImageResource(R.mipmap.app_bottom_five_selected);
                tvToolbarTitle.setText("我");
                if (f4 == null) {
                    f4 = new Fragment4();
                    ft.add(R.id.fl_frame, f4);
                }else {
                    ft.show(f4);
                }
                break;
        }
        ft.commitAllowingStateLoss();         //提交事务
    }

    /****
     * 隐藏 Fragment
     * @param ft
     */
    private void hideFragment(FragmentTransaction ft){
        if (f0 != null) {
            ft.hide(f0);                    // 隐藏 Fragment
        }
        if (f1 != null) {
            ft.hide(f1);
        }
        if (f2 != null) {
            ft.hide(f2);
        }
        if (f3 != null) {
            ft.hide(f3);
        }
        if (f4 != null) {
            ft.hide(f4);
        }
    }

    /****
     * 重置所有图片为未选中状态
     */
    private void resetImg(){
        ibtn0.setImageResource(R.mipmap.app_bottom_one);
        ibtn1.setImageResource(R.mipmap.app_bottom_two);
        ibtn2.setImageResource(R.mipmap.app_bottom_three);
        ibtn3.setImageResource(R.mipmap.app_bottom_four);
        ibtn4.setImageResource(R.mipmap.app_bottom_five);
    }
}
