package com.shanutec.cn.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shanutec.cn.R;
import com.shanutec.cn.base.BaseRecyclerAdapter;
import com.shanutec.cn.base.CommonHolder;
import com.shanutec.cn.bean.Photo;
import com.shanutec.cn.util.ToastUtil;

import butterknife.BindView;


/**
 * Created by lcodecore on 2016/12/7.
 */

public class PhotoAdapter extends BaseRecyclerAdapter<Photo> {
    @Override
    public CommonHolder<Photo> setViewHolder(ViewGroup parent) {
        return new CardHolder(parent.getContext(), parent);
    }

    class CardHolder extends CommonHolder<Photo> {



        @BindView(R.id.tv_info)
        TextView tv_info;

        @BindView(R.id.iv_pic)
        ImageView iv_pic;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_photo);
        }

        @Override
        public void bindData(Photo photo) {
            iv_pic.setImageResource(photo.imgSrc);
            tv_info.setText(photo.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtil.show("item clicked!");
                }
            });
        }
    }
}