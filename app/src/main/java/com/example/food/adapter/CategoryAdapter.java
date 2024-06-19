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
import com.example.food.bean.Category;
import com.example.food.bean.Food;

import java.util.List;

/**
 * @author wellorbetter
 * @since 2024/6/19 17:37
 */
public class CategoryAdapter extends BaseQuickAdapter<Category, BaseViewHolder> {
    public CategoryAdapter(int layoutResId, @Nullable List<Category> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, Category category) {
        ImageView categoryImg = baseViewHolder.findView(R.id.iv_category);
        int drawableId = getContext().getResources().getIdentifier(category.getImagePath()
        , "drawable", getContext().getPackageName());
        Glide.with(getContext())
                .load(drawableId)
                .into(categoryImg);
        switch (baseViewHolder.getLayoutPosition()) {
            case 0:
                categoryImg.setBackgroundResource(R.drawable.category_background_1);
                break;
            case 1:
                categoryImg.setBackgroundResource(R.drawable.category_background_2);
                break;
            case 2:
                categoryImg.setBackgroundResource(R.drawable.category_background_3);
                break;
            case 3:
                categoryImg.setBackgroundResource(R.drawable.category_background_4);
                break;
            case 4:
                categoryImg.setBackgroundResource(R.drawable.category_background_5);
                break;
            case 5:
                categoryImg.setBackgroundResource(R.drawable.category_background_6);
                break;
            case 6:
                categoryImg.setBackgroundResource(R.drawable.category_background_7);
                break;
            default:
                categoryImg.setBackgroundResource(R.drawable.category_background_8);
                break;
        }
        ((TextView) baseViewHolder.findView(R.id.tv_category)).setText(category.getName());
    }
}
