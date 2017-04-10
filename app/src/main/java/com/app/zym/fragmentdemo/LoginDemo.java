package com.app.zym.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zym.fragmentdemo.application.MainApplication;

/**
 * Created by Administrator on 2016/12/18.
 */

public class LoginDemo extends AppCompatActivity implements View.OnClickListener {
    private TextView tvtoold,tvLift;

    private EditText et_user;
    private Button btn_login;

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
        et_user = (EditText) findViewById(R.id.et_user);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
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
                break;
            case R.id.btn_login:
                if("1".equals(et_user.getText().toString())){
                    int index = getIntent().getIntExtra("index", 0);
                    Intent intent = new Intent();
                    intent.setAction(IConfig.actionGoToIndex);
                    intent.putExtra("index", index);

                    sendBroadcast(intent);
                    sendBroadcast(new Intent(IConfig.actionGoToHead));
                    MainApplication.userName = "123456";
                    finish();
                }else{
                    Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
