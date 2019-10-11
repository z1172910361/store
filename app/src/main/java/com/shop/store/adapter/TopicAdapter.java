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

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.MyHolder> {

    private List<IndexBean.DataBean.TopicListBean> topicList ;
    private Context context;

    public TopicAdapter(List<IndexBean.DataBean.TopicListBean> topicList, Context context) {
        this.topicList = topicList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.layout_topic_recyc_item,parent,false);
        return new MyHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Glide.with(context).load(topicList.get(position).getAvatar()).into(holder.iv);
        holder.tv1.setText(topicList.get(position).getTitle());
        holder.tv2.setText("￥"+topicList.get(position).getPrice_info()+"元起");
        holder.tv3.setText(topicList.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public MyHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_topic_recyc_item);
            tv1=itemView.findViewById(R.id.tv1_topic_recyc_item);
            tv2=itemView.findViewById(R.id.tv2_topic_recyc_item);
            tv3=itemView.findViewById(R.id.tv3_topic_recyc_item);
        }
    }
}
