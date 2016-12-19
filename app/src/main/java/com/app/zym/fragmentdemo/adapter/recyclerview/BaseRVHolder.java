package com.app.zym.fragmentdemo.adapter.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zym.fragmentdemo.R;
import com.app.zym.fragmentdemo.adapter.helper.ViewHelper;
import com.bumptech.glide.Glide;

/**
 * Created by zymapp on 2016/11/8.
 */

public class BaseRVHolder extends RecyclerView.ViewHolder implements ViewHelper.RecyclerView<BaseRVHolder> {
    private SparseArray<View> mViews = new SparseArray<>();

    private View mConvertView;
    private int mLayoutId;
    protected Context mContext;

    public BaseRVHolder(Context context, int layoutId, View itemView) {
        super(itemView);
        this.mContext = context;
        this.mLayoutId = layoutId;
        mConvertView = itemView;
        mConvertView.setTag(this);
    }

    public <V extends View> V getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (V) view;
    }

    public int getLayoutId() {
        return mLayoutId;
    }

    /**
     * 获取item布局
     *
     * @return
     */
    public View getItemView() {
        return mConvertView;
    }

    /****
     * 设置item的点击事件
     * @param listener
     * @return
     */
    public BaseRVHolder setOnItemViewClickListener(View.OnClickListener listener){
        mConvertView.setOnClickListener(listener);
        return this;
    }

    /****
     * 设置item的点击事件
     * @param listener      点击事件
     * @param position      当前点击的position
     * @param item          当前点击对应的实体类
     * @param <T>
     * @return
     */
    public <T> BaseRVHolder setOnItemViewClickListener(View.OnClickListener listener, int position, T item){
        mConvertView.setOnClickListener(listener);
        if(position != -100){
            mConvertView.setTag(R.id.tag_position_key, position);
        }
        if(item != null){
            mConvertView.setTag(R.id.tag_item_key,item);
        }
        return this;
    }

    public BaseRVHolder setOnItemViewLongClickListener(View.OnLongClickListener listener){
        mConvertView.setOnLongClickListener(listener);
        return this;
    }
    public <T> BaseRVHolder setOnItemViewLongClickListener(View.OnLongClickListener listener, int position, T item){
        mConvertView.setOnLongClickListener(listener);
        if(position != -100){
            mConvertView.setTag(R.id.tag_position_key, position);
        }
        if(item != null){
            mConvertView.setTag(R.id.tag_item_key,item);
        }
        return this;
    }

    @Override
    public BaseRVHolder setText(int viewId, String value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    @Override
    public BaseRVHolder setTextColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    @Override
    public BaseRVHolder setTextColorRes(int viewId, int colorRes) {
        TextView view = getView(viewId);
        view.setTextColor(ContextCompat.getColor(mContext, colorRes));
        return this;
    }

    @Override
    public BaseRVHolder setImageResource(int viewId, int imgResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imgResId);
        return this;
    }

    @Override
    public BaseRVHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    @Override
    public BaseRVHolder setBackgroundColorRes(int viewId, int colorRes) {
        View view = getView(viewId);
        view.setBackgroundResource(colorRes);
        return this;
    }

    @Override
    public BaseRVHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    @Override
    public BaseRVHolder setImageDrawableRes(int viewId, int drawableRes) {
        Drawable drawable = ContextCompat.getDrawable(mContext,drawableRes);
        return setImageDrawable(viewId, drawable);
    }

    @Override
    public BaseRVHolder setImageUrl(int viewId, String imgUrl) {
        // TODO: Use Glide/Picasso/ImageLoader/Fresco
        final ImageView view = getView(viewId);
        Glide.with(mContext)
                .load(imgUrl)
                .into(view);
                /*.into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        view.setImageDrawable(resource);
                    }
                });*/
        return this;
    }

    @Override
    public BaseRVHolder setImageBitmap(int viewId, Bitmap imgBitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(imgBitmap);
        return this;
    }

    @Override
    public BaseRVHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    @Override
    public BaseRVHolder setVisible(int viewId, int visible) {
        View view = getView(viewId);
        view.setVisibility(visible);
        return this;
    }

    @Override
    public BaseRVHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    @Override
    public BaseRVHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    @Override
    public BaseRVHolder setChecked(int viewId, boolean checked) {
        Checkable view = getView(viewId);
        view.setChecked(checked);
        return this;
    }

    @Override
    public BaseRVHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    @Override
    public BaseRVHolder setTypeface(int viewId, Typeface typeface) {
        TextView view = getView(viewId);
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        return this;
    }

    @Override
    public BaseRVHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    @Override
    public BaseRVHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}
