package com.app.zym.fragmentdemo;

import android.content.Context;
import android.text.TextUtils;

import com.app.zym.fragmentdemo.adapter.recyclerview.BaseRVAdapter;
import com.app.zym.fragmentdemo.adapter.recyclerview.BaseRVHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */

public class FragmentAdapter extends BaseRVAdapter<OneInfo>{
    public FragmentAdapter(Context context, List<OneInfo> list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    protected void onBindData(BaseRVHolder viewHolder, int position, OneInfo item) {
        super.onBindData(viewHolder, position, item);
        if(TextUtils.isEmpty(item.title)){
            viewHolder.setImageUrl(R.id.iv_icon,"http://120.25.204.7:8000"+ item.head)
                    .setText(R.id.tv_name,item.name);
        }else {
            viewHolder.setText(R.id.tv_title_left, item.title);
        }
    }

    @Override
    public int getLayoutIndex(int position, OneInfo item) {
        return TextUtils.isEmpty(item.title)?1:0;
    }
}
