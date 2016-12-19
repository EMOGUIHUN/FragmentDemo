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
 * Created by Administrator on 2016/12/9.
 */

public class Fragment3 extends Fragment implements OKHttpRequest.AsyncRequest{
    private ListView mList;
    private List<NearInfo> mlist;
    private NearAdapter mAdapter;
    private OKHttpRequest ohr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        mList = (ListView) view.findViewById(R.id.lv_near);
        ohr = new OKHttpRequest(this);
        send();
        mlist = new ArrayList<>();
        mAdapter = new NearAdapter(getActivity(),mlist,R.layout.fragment_near_item);
        mList.setAdapter(mAdapter);
        return view;
    }
    public void send(){
        RequestParams rp = new RequestParams();
        rp.setTag(0);
        rp.addFormDataPart("sProcName","select_virtual_forFirstPage");
        rp.addFormDataPart("init","0");
        ohr.post(getActivity(),"http://120.25.204.7:8081/xmppinterface_tcyy/Interfaces",rp);
    }
    /****
     * 网络请求回调方法
     *
     * @param isSuccess 网络请求是否成功
     * @param json      服务器返回的json数据
     * @param tag       标识哪一个网络请求
     */
    @Override
    public void callBack(boolean isSuccess, String json, int tag) {
        if(TextUtils.isEmpty(json)){
            return;
        }
        if(tag ==0){
            try {
                JSONObject obj = new JSONObject(json);
                if(obj.has("data1")){
                    JSONArray array = obj.getJSONArray("data1");
                    if(array==null){
                        return;
                    }
                    for(int i = 0;i<array.length();i++){
                        JSONObject objs = array.getJSONObject(i);
                        NearInfo ni = new NearInfo();
                        if(objs.has("age")) ni.age = objs.getString("age");
                        if(objs.has("name"))ni.name = objs.getString("name");
                        if(objs.has("header")) ni.head = objs.getString("header");
                        mlist.add(ni);
                    }
                    mAdapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
