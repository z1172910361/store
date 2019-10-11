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

public class HotGoodsAdapter extends RecyclerView.Adapter<HotGoodsAdapter.MyHolder> {

   private List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList ;
   private Context context;

    public HotGoodsAdapter(List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList, Context context) {
        this.hotGoodsList = hotGoodsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout_hotgoods_recyc_item,parent,false);

        return new MyHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Glide.with(context).load(hotGoodsList.get(position).getList_pic_url()).into(holder.iv);
        holder.tv1.setText(hotGoodsList.get(position).getName());
        holder.tv2.setText(hotGoodsList.get(position).getGoods_brief());
        holder.tv3.setText("￥"+hotGoodsList.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return hotGoodsList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;


        public MyHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_hotgoods_recyc_item);
            tv1=itemView.findViewById(R.id.tv1_hotgoods_recyc_item);
            tv2=itemView.findViewById(R.id.tv2_hotgoods_recyc_item);
            tv3=itemView.findViewById(R.id.tv3_hotgoods_recyc_item);

        }
    }
}
