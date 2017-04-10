package com.app.zym.fragmentdemo;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/9.
 */

public class Fragment4 extends Fragment implements IConfig{
    private ListView mList;
    private List<MeInfo> mlist;
    private MeAdapter mAdapter;
    private MyBroadcastReceiver mbr;


    private class MyBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent==null){
                return;
            }
            if(actionGoToHead.equals(intent.getAction())){
                if(mAdapter!=null){
                    ImageView iv = mAdapter.getHead();
                    if(iv!=null){
                        iv.setImageResource(R.mipmap.jp);
                    }
                }
            }
        }
    }

    private void broadcast(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(actionGoToHead);
        mbr = new MyBroadcastReceiver();
        getActivity().registerReceiver(mbr,filter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        broadcast();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);
        mList = (ListView) view.findViewById(R.id.lv_me);
        initData();
        int[] layouts = new int[]{R.layout.lv_five_head,R.layout.lv_five_btn_item,R.layout.lv_five_icon_item};
        mAdapter = new MeAdapter(getActivity(),mlist,layouts);
        mList.setAdapter(mAdapter);

        return view;
    }
    public void initData(){
        mlist = new ArrayList<>();
        MeInfo mi = new MeInfo();
        mi.Type = 1;
        mlist.add(mi);
        mi = new MeInfo();
        mi.Type = 2;
        mlist.add(mi);
        for(int i = 1;i<=7;i++){
            mi = new MeInfo();
            mi.Type = 3;
            mlist.add(mi);
        }
    }

    @Override
    public void onDestroy() {
        if(mbr!=null){
            getActivity().unregisterReceiver(mbr);
        }
        super.onDestroy();
    }
}
