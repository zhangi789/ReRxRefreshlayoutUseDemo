package com.shanutec.cn.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.kit.cn.view.CircleImageView;
import com.shanutec.cn.R;
import com.shanutec.cn.base.BaseRecyclerAdapter;
import com.shanutec.cn.base.CommonHolder;
import com.shanutec.cn.bean.Food;
import com.shanutec.cn.util.ToastUtil;

import butterknife.BindView;


/**
 * Created by lcodecore on 2016/12/6.
 */

public class FoodAdapter extends BaseRecyclerAdapter<Food> {
    @Override
    public CommonHolder<Food> setViewHolder(ViewGroup parent) {
        return new CardHolder(parent.getContext(), parent);
    }

    class CardHolder extends CommonHolder<Food> {

        @BindView(R.id.avatar)
        CircleImageView avatar;

        @BindView(R.id.tv_food)
        TextView tv_food;

        @BindView(R.id.tv_info)
        TextView tv_info;

        @BindView(R.id.iv_food)
        ImageView iv_food;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_food);
        }

        @Override
        public void bindData(Food food) {
            avatar.setImageResource(food.avatar_id);
            iv_food.setImageResource(food.imageSrc);
            tv_food.setText(food.title);
            tv_info.setText(food.info);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtil.show("item clicked!");
                }
            });
        }
    }
}
