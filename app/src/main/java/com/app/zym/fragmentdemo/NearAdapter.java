package com.app.zym.fragmentdemo;

import android.content.Context;

import com.app.zym.fragmentdemo.adapter.abslistview.BaseLVAdapte;
import com.app.zym.fragmentdemo.adapter.abslistview.BaseLVHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public class NearAdapter extends BaseLVAdapte<NearInfo> {
    private Context  context;
    public NearAdapter(Context context, List<NearInfo> list, int... layoutIds) {
        super(context, list, layoutIds);
        this.context = context;
    }

    @Override
    public void convert(BaseLVHolder holder, int position, NearInfo nearInfo) {
        holder.setText(R.id.tv_name,nearInfo.name)
                .setText(R.id.tv_age,nearInfo.age)
                .setText(R.id.tv_context,nearInfo.context)
                .setImageUrl(R.id.iv_head,"http://120.25.204.7:8000"+nearInfo.head);
    }
}
