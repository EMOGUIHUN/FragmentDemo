package com.app.zym.fragmentdemo;

import android.content.Context;
import android.widget.ImageView;

import com.app.zym.fragmentdemo.adapter.abslistview.BaseLVAdapte;
import com.app.zym.fragmentdemo.adapter.abslistview.BaseLVHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */

public class MeAdapter extends BaseLVAdapte<MeInfo> {
    private Context context;
    public MeAdapter(Context context, List<MeInfo> list, int... layoutIds) {
        super(context, list, layoutIds);
        this.context = context;
    }

    private ImageView iv;

    @Override
    public void convert(BaseLVHolder holder, int position, MeInfo meInfo) {
        if(meInfo.Type == 1){
            iv = holder.getView(R.id.riv_head);
            getHead();
        }
    }

    @Override
    public int getLayoutIndex(int position, MeInfo item) {
        int layout = 0;
        if(item.Type ==1){
            layout = 0;
        }else if(item.Type==2){
            layout = 1;
        }else{
            layout = 2;
        }
        return layout;
    }

    public ImageView getHead(){
        return iv;
    }



}
