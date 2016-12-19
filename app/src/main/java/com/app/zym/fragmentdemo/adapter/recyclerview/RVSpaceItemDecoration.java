package com.app.zym.fragmentdemo.adapter.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 用于设置 RecyclerView 间距
 * Created by zymapp on 2016/11/24.
 */

public class RVSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;


    public RVSpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        //不是第一个的格子都设一个左边和底部的间距
        outRect.left = space;
        outRect.bottom = space;
        outRect.top = space;
        outRect.right = space;
    }

}
