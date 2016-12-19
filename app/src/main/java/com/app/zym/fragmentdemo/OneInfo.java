package com.app.zym.fragmentdemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/12/18.
 */

public class OneInfo {
    public OneInfo(){}

    public OneInfo(JSONObject obj) throws JSONException {
        if(obj.has("name")) name = obj.getString("name");
        if(obj.has("header")) head = obj.getString("header");
    }
    public String title;
    public String head;
    public String name;
}
