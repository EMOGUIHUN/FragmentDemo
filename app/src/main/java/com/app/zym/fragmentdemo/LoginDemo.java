package com.app.zym.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/18.
 */

public class LoginDemo extends AppCompatActivity implements View.OnClickListener {
    private TextView tvtoold,tvLift;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tvtoold = (TextView) findViewById(R.id.tv_toolbar_title);
        tvLift = (TextView) findViewById(R.id.tv_toolbar_left);
        tvLift.setOnClickListener(this);
        tvLift.setVisibility(View.VISIBLE);
        tvLift.setBackgroundResource(R.mipmap.def_back);
        tvtoold.setText("登陆");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_toolbar_left:
                finish();
        }
    }
}
