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
import com.shop.store.model.bean.IndexBean;

import java.util.List;

/**
 * Created by lenovo on 2019/8/24.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {
private List<IndexBean.DataBean.CategoryListBean.GoodsListBean> goodsList;
private Context context;

    public CategoryAdapter(List<IndexBean.DataBean.CategoryListBean.GoodsListBean> goodsList,
                           Context context) {
        this.goodsList = goodsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout_category_recyc_item,parent,false);

        return new MyHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Glide.with(context).load(goodsList.get(position).getList_pic_url()).into(holder.iv);
        holder.tv1.setText(goodsList.get(position).getName());
        holder.tv2.setText("￥"+goodsList.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv1;
        TextView tv2;


        public MyHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_category_recyc_item);
            tv1=itemView.findViewById(R.id.tv1_category_recyc_item);
            tv2=itemView.findViewById(R.id.tv2_category_recyc_item);
        }
    }

}
