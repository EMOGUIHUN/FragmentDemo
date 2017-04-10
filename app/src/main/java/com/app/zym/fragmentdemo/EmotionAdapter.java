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
 * Created by Administrator on 2016/12/21.
 */

public class EmotionAdapter extends BaseLVAdapte<EmotionInfo> {
    private Context context;
    public EmotionAdapter(Context context, List<EmotionInfo> list, int... layoutIds) {
        super(context, list, layoutIds);
        this.context = context;
    }

    @Override
    public void convert(BaseLVHolder holder, int position, EmotionInfo emotionInfo) {
        holder.setText(R.id.tv_anony,emotionInfo.smallTitle)
                .setText(R.id.tv_context,emotionInfo.info)
                .setText(R.id.tv_name,emotionInfo.name)
                .setText(R.id.tv_age,emotionInfo.age)
                .setImageUrl(R.id.iv_head,"http://120.25.204.7:8000"+emotionInfo.head);
        String img = emotionInfo.pic;
        if(!TextUtils.isEmpty(img)){
            String[] imgPathsArray = img.split(",");
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
