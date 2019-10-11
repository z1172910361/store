package com.shop.store.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.model.bean.ShopDetailElseBean;

import java.util.List;

/*
 *作者:SeeHeart 2019/9/23 15:14
 */
public class ShopDetailElseAdapter extends RecyclerView.Adapter<ShopDetailElseAdapter.ShopDetailElseHolder> {
    private List<ShopDetailElseBean.DataBean.GoodsListBean> list;
    private Context context;

    public ShopDetailElseAdapter(List<ShopDetailElseBean.DataBean.GoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopDetailElseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_category_recyc_item, viewGroup, false);
        return new ShopDetailElseHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ShopDetailElseHolder shopDetailElseHolder, final int i) {
        Glide.with(context).load(list.get(i).getList_pic_url()).into(shopDetailElseHolder.iv);
        shopDetailElseHolder.titletv.setText(list.get(i).getName());
        shopDetailElseHolder.pricetv.setText(list.get(i).getRetail_price() + "");

        shopDetailElseHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shopDetailElseOnClick != null)
                    shopDetailElseOnClick.shopElseOnItemClickListener(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShopDetailElseHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView titletv;
        TextView pricetv;

        public ShopDetailElseHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_category_recyc_item);
            titletv = itemView.findViewById(R.id.tv1_category_recyc_item);
            pricetv = itemView.findViewById(R.id.tv2_category_recyc_item);
        }
    }

    public interface ShopDetailElseOnClick {
        void shopElseOnItemClickListener(int position);
    }

    private ShopDetailElseOnClick shopDetailElseOnClick;

    public void setShopElseOnClick(ShopDetailElseOnClick shopDetailElseOnClick) {
        this.shopDetailElseOnClick = shopDetailElseOnClick;
    }
}
