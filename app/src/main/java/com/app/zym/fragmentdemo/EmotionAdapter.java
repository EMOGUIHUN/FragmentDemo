package com.app.zym.fragmentdemo;

import android.content.Context;
import android.text.TextUtils;

import com.app.zym.fragmentdemo.adapter.abslistview.BaseLVAdapte;
import com.app.zym.fragmentdemo.adapter.abslistview.BaseLVHolder;
import com.app.zym.fragmentdemo.grid.BaseNineGridAdapter;
import com.app.zym.fragmentdemo.grid.NineGridlayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public class EmotionAdapter extends BaseLVAdapte<EmotionInfo> {
    private Context context;
    public EmotionAdapter(Context context, List<EmotionInfo> list, int... layoutIds) {
        super(context, list, layoutIds);
        this.context = context;
    }

    @Override
    public void convert(BaseLVHolder holder, int position, EmotionInfo emotionInfo) {
        holder.setText(R.id.tv_anony, emotionInfo.anony)
                .setText(R.id.tv_adr, emotionInfo.adr)
                .setText(R.id.tv_age, emotionInfo.age)
                .setText(R.id.tv_leave, emotionInfo.leave)
                .setText(R.id.tv_day, emotionInfo.day)
                .setText(R.id.tv_context, emotionInfo.context)
                .setText(R.id.tv_name, emotionInfo.name)
                .setText(R.id.tv_like, emotionInfo.like)
                .setImageUrl(R.id.iv_head, "http://120.25.204.7:8000"+ emotionInfo.head);
        String imgPaths = emotionInfo.photo;
        if(!TextUtils.isEmpty(imgPaths)){
            String[] imgPathsArray = imgPaths.split(",");
            List<NineImage> listImg = new ArrayList<>();
            for (String  imgPath: imgPathsArray) {
                NineImage ni = new NineImage(imgPath, 250, 250);
                listImg.add(ni);
            }
            NineGridlayout ng = holder.getView(R.id.iv_photo);
            ng.setAdapter(new BaseNineGridAdapter(context,listImg));
        }
    }
}
