package com.app.zym.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2016/12/24.
 */

public class ActivityUserInfo extends AppCompatActivity {

    public static final String head = "head";
    public static final String name = "name";
    public static final String age = "age";

    private ImageView ivHead;
    private TextView tvName, tvAge, tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText("第一种传参");
        ivHead = (ImageView) findViewById(R.id.iv_head);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvAge = (TextView) findViewById(R.id.tv_age);

        String mHead = getIntent().getStringExtra(head);
        String mName = getIntent().getStringExtra(name);
        String mAge = getIntent().getStringExtra(age);

        Glide.with(this)
                .load(IConfig.imgURL + mHead)
                .into(ivHead);
        tvName.setText("名字是："+mName);
        tvAge.setText("年龄是："+ mAge + "岁");
    }
}
