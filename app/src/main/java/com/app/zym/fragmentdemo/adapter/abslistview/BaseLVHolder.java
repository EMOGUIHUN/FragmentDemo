package com.app.zym.fragmentdemo.adapter.abslistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zym.fragmentdemo.adapter.helper.ViewHelper;
import com.bumptech.glide.Glide;


/**
 * Created by zymapp on 2016/11/8.
 */

public class BaseLVHolder implements ViewHelper.AbsListView<BaseLVHolder> {
    /**
     * findViewById后保存View集合
     */
    private SparseArray<View> mViews = new SparseArray<>();
    private SparseArray<View> mConvertViews = new SparseArray<>();

    private View mConvertView;
    protected int mPosition;
    protected int mLayoutId;
    protected Context mContext;

    protected BaseLVHolder(Context context, int position, ViewGroup parent, int layoutId) {
        this.mConvertView = mConvertViews.get(layoutId);
        this.mPosition = position;
        this.mContext = context;
        this.mLayoutId = layoutId;
        if (mConvertView == null) {
            mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            mConvertViews.put(layoutId, mConvertView);
            mConvertView.setTag(this);
        }
    }

    protected BaseLVHolder() {
    }

    public <BVH extends BaseLVHolder> BVH get(Context context, int position, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return (BVH) new BaseLVHolder(context, position, parent, layoutId);
        } else {
            BaseLVHolder holder = (BaseLVHolder) convertView.getTag();
            if (holder.mLayoutId != layoutId) {
                return (BVH) new BaseLVHolder(context, position, parent, layoutId);
            }
            holder.setPosition(position);
            return (BVH) holder;
        }
    }

    /**
     * 获取item布局
     * @return
     */
    public View getConvertView() {
        return mConvertViews.valueAt(0);
    }

    public View getConvertView(int layoutId) {
        return mConvertViews.get(layoutId);
    }

    public <V extends View> V getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (V) view;
    }

    public void setPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public int getLayoutId() {
        return mLayoutId;
    }

    @Override
    public BaseLVHolder setText(int viewId, String value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    @Override
    public BaseLVHolder setTextColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    @Override
    public BaseLVHolder setTextColorRes(int viewId, int colorRes) {
        TextView view = getView(viewId);
        view.setTextColor(ContextCompat.getColor(mContext,colorRes));
        return this;
    }

    @Override
    public BaseLVHolder setImageResource(int viewId, int imgResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imgResId);
        return this;
    }

    @Override
    public BaseLVHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    @Override
    public BaseLVHolder setBackgroundColorRes(int viewId, int colorRes) {
        View view = getView(viewId);
        view.setBackgroundResource(colorRes);
        return this;
    }

    @Override
    public BaseLVHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    @Override
    public BaseLVHolder setImageDrawableRes(int viewId, int drawableRes) {
        Drawable drawable = ContextCompat.getDrawable(mContext, drawableRes);
        return setImageDrawable(viewId, drawable);
    }

    @Override
    public BaseLVHolder setImageUrl(int viewId, String imgUrl) {
        // TODO: Use Glide/Picasso/ImageLoader/Fresco
        final ImageView view = getView(viewId);
        Glide.with(mContext)
                .load(imgUrl)
                .into(view);
        return this;
    }

    @Override
    public BaseLVHolder setImageBitmap(int viewId, Bitmap imgBitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(imgBitmap);
        return this;
    }

    @Override
    public BaseLVHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    @Override
    public BaseLVHolder setVisible(int viewId, int visible) {
        View view = getView(viewId);
        view.setVisibility(visible);
        return this;
    }

    @Override
    public BaseLVHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    @Override
    public BaseLVHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    @Override
    public BaseLVHolder setChecked(int viewId, boolean checked) {
        Checkable view = getView(viewId);
        view.setChecked(checked);
        return this;
    }

    @Override
    public BaseLVHolder setAlpha(int viewId, float value) {
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
    public BaseLVHolder setTypeface(int viewId, Typeface typeface) {
        TextView view = getView(viewId);
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        return this;
    }

    @Override
    public BaseLVHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    @Override
    public BaseLVHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

}
