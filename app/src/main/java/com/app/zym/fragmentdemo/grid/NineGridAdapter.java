package com.app.zym.fragmentdemo.grid;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * 适配器
 */
public abstract class NineGridAdapter {
    protected Context context;
    protected List list;

    public NineGridAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    public abstract int getCount();

    public abstract String getUrl(int position);

    public abstract Object getItem(int position);

    public abstract long getItemId(int position);

    public abstract View getView(int i, View view);
}
