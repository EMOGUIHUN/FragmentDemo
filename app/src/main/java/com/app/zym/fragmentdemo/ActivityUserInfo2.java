package com.app.zym.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2016/12/24.
 */

public class ActivityUserInfo2 extends AppCompatActivity {
    public static final String head = "head";
    public static final String name = "name";
    public static final String age = "age";

    public static final String bundle = "mBundle";

    private ImageView ivHead;
    private TextView tvName, tvAge, tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText("第二种传参");
        ivHead = (ImageView) findViewById(R.id.iv_head);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvAge = (TextView) findViewById(R.id.tv_age);

        Intent mIntent = getIntent();
        if(mIntent != null){
            Bundle mBundle = mIntent.getBundleExtra(bundle);
            if(mBundle!=null){
                Glide.with(this)
                        .load(IConfig.imgURL + mBundle.getString(head))
                        .into(ivHead);
                tvName.setText("名字是："+mBundle.getString(name));
                tvAge.setText("年龄是："+ mBundle.getString(age) + "岁");
            }
        }
    }
}
