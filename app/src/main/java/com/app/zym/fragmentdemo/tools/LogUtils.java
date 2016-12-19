package com.app.zym.fragmentdemo.tools;

import android.util.Log;

/**
 * Created by Administrator on 2016/12/12.
 */

public class LogUtils {

    private boolean isDebug = true;

    private LogUtils(){}
    private static  class LogHolder{
        public static LogUtils lu = new LogUtils();
    }
    public static LogUtils getLog(){
        return LogUtils.LogHolder.lu;
    }

    public void init(boolean isDebug){
        this.isDebug = isDebug;
    }

    public void d(String tag, String content){
        if(isDebug){
            Log.d(tag,content);
        }
    }

}
