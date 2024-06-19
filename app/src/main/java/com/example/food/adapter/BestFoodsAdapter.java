package com.example.food.adapter;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.food.R;
import com.example.food.bean.Food;

import java.util.List;

/**
 * @author wellorbetter
 * @since 2024/6/19 17:37
 */
public class BestFoodsAdapter extends BaseQuickAdapter<Food, BaseViewHolder> {
    public BestFoodsAdapter(int layoutResId, @Nullable List<Food> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, Food food) {
        ImageView foodImg = baseViewHolder.findView(R.id.iv_food);
        // 居中加圆角
        Glide.with(getContext())
                .load(Uri.parse(food.getImagePath()))
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(foodImg);
        ((TextView) baseViewHolder.findView(R.id.tv_title)).setText(food.getTitle());
        ((TextView) baseViewHolder.findView(R.id.tv_star_number)).setText(String.valueOf(food.getStar()));
        ((TextView) baseViewHolder.findView(R.id.tv_time_number)).setText(String.valueOf(food.getTimeValue()));
        ((TextView) baseViewHolder.findView(R.id.tv_price)).setText(String.valueOf(food.getPrice()) + "元");
    }
}
