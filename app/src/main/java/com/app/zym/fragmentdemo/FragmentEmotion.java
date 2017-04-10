package com.app.zym.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.zym.fragmentdemo.request.RequestParams;
import com.app.zym.fragmentdemo.tools.OKHttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/12/21.
 */

public class FragmentEmotion extends Fragment implements OKHttpRequest.AsyncRequest {
    private static final String EXTRA_REQUEST_TYPE = "1";
    //解决带参数的构造函数
    public static final FragmentEmotion newInstance(String requestType){
        FragmentEmotion fe = new FragmentEmotion();
        Bundle extra = new Bundle();
        extra.putString(EXTRA_REQUEST_TYPE, requestType);
        fe.setArguments(extra);
        return fe;
    }
    private ListView lvView;
    private List<EmotionInfo> mlist;
    private EmotionAdapter mAdapter;
    private String requestType;
    private OKHttpRequest ohr;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lv_emotion,container,false);
        ohr = new OKHttpRequest(this);
        lvView = (ListView) view.findViewById(R.id.lv_emotion);
        sendRequest();
        mlist = new ArrayList<>();
        mAdapter = new EmotionAdapter(getActivity(),mlist,R.layout.fragment_emotion_item);
        lvView.setAdapter(mAdapter);
        return view;
    }
    private void sendRequest(){
        requestType = getArguments().getString(EXTRA_REQUEST_TYPE);
        RequestParams rp = new RequestParams();
        rp.setTag(0);
        rp.addFormDataPart("sProcName","selectFeeling");
        rp.addFormDataPart("p_page_size","5");
        rp.addFormDataPart("p_page_now","1");
        rp.addFormDataPart("getType",requestType);
        rp.addFormDataPart("userId","");
        ohr.post(getActivity(), "http://120.25.204.7:8081/xmppinterface_tcyy/Interfaces", rp);
    }
    @Override
    public void callBack(boolean isSuccess, String json, int tag) {
        if(TextUtils.isEmpty(json)){
            return;
        }
        if(tag==0){
            try {
                JSONObject obj = new JSONObject(json);
                if(obj.has("data1")){
                    JSONArray array = obj.getJSONArray("data1");
                    if(array==null){
                        return;
                    }
                    for(int i = 0;i<array.length();i++){
                        JSONObject objs = array.getJSONObject(i);
                        EmotionInfo ei = new EmotionInfo();
                        if(objs.has("age"))ei.age = objs.getString("age");
                        if(objs.has("name"))ei.name = objs.getString("name");
                        if(objs.has("smallTitle"))ei.smallTitle = objs.getString("smallTitle");
                        if(objs.has("info"))ei.info = objs.getString("info");
                        if(objs.has("userPic"))ei.head = objs.getString("userPic");
                        if(objs.has("pic"))ei.pic = objs.getString("pic");
                        mlist.add(ei);
                    }
                    mAdapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
