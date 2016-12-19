package com.app.zym.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.zym.fragmentdemo.adapter.recyclerview.RVSpaceItemDecoration;
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

public class Fragment0 extends Fragment implements OKHttpRequest.AsyncRequest {
    private OKHttpRequest ohr;
    private RecyclerView rvView;
    private List<OneInfo> mlist;
    private FragmentAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_0, container, false);
        ohr = new OKHttpRequest(this);
        rvView = (RecyclerView) view.findViewById(R.id.rv_main);
        sendRequest();
        mlist = new ArrayList<>();
        int [] layouts = new int[]{R.layout.fragment_ont_item_title,R.layout.fragment_one_item_head};
        mAdapter = new FragmentAdapter(getActivity(),mlist,layouts);
        mAdapter.setLayoutType(0,3);
        rvView.addItemDecoration(new  RVSpaceItemDecoration(5));
        GridLayoutManager gridLayoutManager =new  GridLayoutManager(getActivity(),3);
        rvView.setLayoutManager(gridLayoutManager);
        rvView.setItemAnimator(new DefaultItemAnimator());
        rvView.setHasFixedSize(true);
        rvView.setAdapter(mAdapter);
        return view;
    }
    public void sendRequest(){
        RequestParams rp = new RequestParams();
        rp.setTag(0);
        rp.addFormDataPart("sProcName","selectFirstPages");
        rp.addFormDataPart("i_sex","1");
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
                JSONObject obj  = new JSONObject(json);
                if(obj.has("meinv")){
                    JSONArray array = obj.getJSONArray("meinv");
                    if(array==null){
                        return;
                    }
                    for(int i = 0;i<array.length();i++){
                        JSONObject objs = array.getJSONObject(i);
                        if(objs.has("title")){
                            OneInfo oi = new OneInfo();
                            oi.title = objs.getString("title");
                            mlist.add(oi);
                        }
                        if(objs.has("list")){
                            JSONArray arrays = objs.getJSONArray("list");
                            if(arrays==null){
                                return;
                            }
                            for(int j = 0;j<arrays.length();j++){
                                JSONObject itemObj = arrays.getJSONObject(j);
                                OneInfo oi = new OneInfo();
                                if(itemObj.has("header")) oi.head = itemObj.getString("header");
                                if(itemObj.has("name")) oi.name = itemObj.getString("name");
                                mlist.add(oi);
                            }
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
