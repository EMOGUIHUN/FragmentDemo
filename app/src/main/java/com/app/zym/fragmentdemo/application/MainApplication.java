package com.app.zym.fragmentdemo.application;

import android.app.Application;
import android.text.TextUtils;


import com.app.zym.fragmentdemo.request.OkHttp;
import com.app.zym.fragmentdemo.request.OkHttpConfig;
import com.app.zym.fragmentdemo.request.Part;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Interceptor;


/**
 * Created by Administrator on 2016/12/12.
 */

public class MainApplication extends Application {
    public static String userName = "";
    @Override
    public void onCreate() {
        super.onCreate();

        // region 初始化网络请求
        List<Part> commonParams = new ArrayList<>();
        Headers commonHeaders = new Headers.Builder().build();
        List<Interceptor> interceptorList = new ArrayList<>();
        OkHttpConfig.Builder builder = new OkHttpConfig.Builder()
                .setCommenParams(commonParams)
                .setCommenHeaders(commonHeaders)
                .setTimeout(30000)
                .setInterceptors(interceptorList)
                .setDebug(true);
        OkHttp.getInstance().init(builder.build());
        // endregion
    }
    public static boolean isLogin(){
        if(TextUtils.isEmpty(userName)){
            return false;
        }else{
            return true;
        }
    }
}
