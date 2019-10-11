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
import com.shop.store.model.bean.ChannelListBean;

import java.util.List;

/*
 *作者:SeeHeart 2019/9/23 15:14
 */
public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.BrandListHolder> {
    private List<ChannelListBean.DataBeanX.GoodsListBean> list;
    private Context context;

    public ChannelListAdapter(List<ChannelListBean.DataBeanX.GoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BrandListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_category_recyc_item, viewGroup, false);
        return new BrandListHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BrandListHolder brandListHolder, final int i) {
        Glide.with(context).load(list.get(i).getList_pic_url()).into(brandListHolder.iv);
        brandListHolder.titletv.setText(list.get(i).getName());
        brandListHolder.pricetv.setText(list.get(i).getRetail_price() + "");

        brandListHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (channelOnClick != null)
                    channelOnClick.channelOnItemClickListener(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BrandListHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView titletv;
        TextView pricetv;

        public BrandListHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_category_recyc_item);
            titletv = itemView.findViewById(R.id.tv1_category_recyc_item);
            pricetv = itemView.findViewById(R.id.tv2_category_recyc_item);
        }
    }

    public interface ChannelOnClick {
        void channelOnItemClickListener(int position);
    }

    private ChannelOnClick channelOnClick;

    public void setChannelOnClick(ChannelOnClick channelOnClick) {
        this.channelOnClick = channelOnClick;
    }
}
