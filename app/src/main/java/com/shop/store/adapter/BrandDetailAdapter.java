package com.shop.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.store.R;

/*
 *作者:SeeHeart 2019/9/24 17:16
 */
public class BrandDetailAdapter extends RecyclerView.Adapter<BrandDetailAdapter.BrandDetailHolder> {

    private Context context;

    @NonNull
    @Override
    public BrandDetailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_category_recyc_item, viewGroup, false);
        return new BrandDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandDetailHolder brandDetailHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BrandDetailHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView titletv;
        TextView pricetv;
        public BrandDetailHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_category_recyc_item);
            titletv = itemView.findViewById(R.id.tv1_category_recyc_item);
            pricetv = itemView.findViewById(R.id.tv2_category_recyc_item);
        }
    }
}
