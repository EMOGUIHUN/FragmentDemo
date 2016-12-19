package com.app.zym.fragmentdemo.grid;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;


import com.app.zym.fragmentdemo.NineImage;
import com.app.zym.fragmentdemo.R;
import com.app.zym.fragmentdemo.view.RoundImageView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 *
 * Created by Administrator on 2016/12/16.
 */

public class BaseNineGridAdapter extends NineGridAdapter {
    public BaseNineGridAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public String getUrl(int position) {
        return ((NineImage)getItem(position)).getUrl();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view) {
        RoundImageView iv = null;
        if (view != null && view instanceof RoundImageView) {
            iv = (RoundImageView) view;
        } else {
            iv = new RoundImageView(context);
        }
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setType(RoundImageView.TYPE_ROUND);
        String url = "http://120.25.204.7:8000" + getUrl(i);
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(iv);
        return iv;
    }
}
