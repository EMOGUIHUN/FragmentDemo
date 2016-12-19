package com.app.zym.fragmentdemo.adapter.recyclerview;

import android.content.Context;
import android.view.View;


import com.app.zym.fragmentdemo.R;

import java.util.List;

/**
 * Created by zymapp on 2016/11/8.
 * 使用示例：
 * public class RecyclerViewAdapter extends BaseRVAdapter<Bean> {
 * public RecyclerViewAdapter(Context context, List<Bean> list, int... layoutIds) {
 * super(context, list, layoutIds);
 * }

 * @Override
 * protected void onBindData(EasyRVHolder viewHolder, int position, Bean item) {
 * //如果不想暴露 item 的点击事件就直接继承 EasyRVAdapter 即可
 * super.onBindData(viewHolder, position, item);//调用父类来暴露item的点击事件
 * viewHolder.setText(R.id.tv, item.name);
 * }

 * @Override
 * public int getLayoutIndex(int position, Bean item) {
 * if (position % 2 == 0)
 * return 0;
 * else return 1;
 * }
 * }
 */

public class BaseRVAdapter<T> extends EasyRVAdapter<T> implements View.OnClickListener, View.OnLongClickListener {
    private ItemClick ic;
    private OnItemClick oic;
    private OnItemLongClick oil;

    public BaseRVAdapter(Context context, List<T> list, int... layoutIds) {
        super(context, list, layoutIds);
    }

    @Override
    protected void onBindData(BaseRVHolder viewHolder, final int position, final T item) {
        viewHolder.setOnItemViewClickListener(this, position, item);
        viewHolder.setOnItemViewLongClickListener(this, position, item);
    }

    /****
     * 设置 RecyclerView Item 点击事件 和 长按事件 的回调
     * @param ic
     */
    public void setClick(ItemClick<T> ic){
        this.ic = ic;
    }
    /****
     * 设置 RecyclerView Item 点击事件 的回调
     * @param oic
     */
    public void setClick(OnItemClick<T> oic){
        this.oic = oic;
    }
    /****
     * 设置 RecyclerView Item 长按事件 的回调
     * @param oil
     */
    public void setClick(OnItemLongClick<T> oil){
        this.oil = oil;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int position = (int) v.getTag(R.id.tag_position_key);
        T item = (T) v.getTag(R.id.tag_item_key);
        if(ic!=null){
            ic.onItemClick(v, v.getId(), position,item);
        }
        if(oic!=null){
            oic.onItemClick(v, v.getId(),position,item);
        }
    }

    /**
     * Called when a view has been clicked and held.
     *
     * @param v The view that was clicked and held.
     * @return true if the callback consumed the long click, false otherwise.
     */
    @Override
    public boolean onLongClick(View v) {
        int position = (int) v.getTag(R.id.tag_position_key);
        T item = (T) v.getTag(R.id.tag_item_key);
        if(ic!=null){
            ic.onItemLongClick(v, v.getId(),position,item);
        }
        if(oil!=null){
            oil.onItemLongClick(v, v.getId(),position,item);
        }
        return false;
    }

    /****
     * RecyclerView Item 的点击事件 和 长按事件
     * @param <T>
     */
    public interface ItemClick<T>{
        void onItemClick(View v, int vId, int position, T item);
        void onItemLongClick(View v, int vId, int position, T item);
    }

    /****
     * RecyclerView Item 的点击事件
     * @param <T>
     */
    public interface OnItemClick<T>{
        void onItemClick(View v, int vId, int position, T item);
    }

    /****
     * RecyclerView Item 的长按事件
     * @param <T>
     */
    public interface OnItemLongClick<T>{
        void onItemLongClick(View v, int vId, int position, T item);
    }
}
