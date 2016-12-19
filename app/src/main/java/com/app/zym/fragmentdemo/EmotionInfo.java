package com.app.zym.fragmentdemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/12/19.
 */

public class EmotionInfo {
    public EmotionInfo(JSONObject obj) throws JSONException {
        if(obj.has("age")){
            age = obj.getString("age");
        }
        if(obj.has("smallTitle")){
            anony = obj.getString("smallTitle");
        }
        if(obj.has("name")){
            name = obj.getString("name");
        }
        if(obj.has("info")){
            context = obj.getString("info");
        }
        if(obj.has("userPic")){
            head = obj.getString("userPic");
        }
        if(obj.has("pic")){
            photo = obj.getString("pic");
        }
    }
    public String anony;
    public String context;
    public String  photo;
    public String  head;
    public String name;
    public String age;
    public String adr;
    public String like;
    public String leave;
    public String day;
}
