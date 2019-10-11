package com.shop.store.adapter;

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
import com.shop.store.model.bean.CatalogCurrentBean;

import java.util.List;


public class CurrentCategoryAdapter extends RecyclerView.Adapter<CurrentCategoryAdapter.CurrentCategoryHolder> {
    private List<CatalogCurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList;
    private Context context;

    public CurrentCategoryAdapter(List<CatalogCurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList, Context context) {
        this.subCategoryList = subCategoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CurrentCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_current_item, parent, false);
        return new CurrentCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentCategoryHolder holder, int position) {
        holder.current_item_tv.setText(subCategoryList.get(position).getName());
        Glide.with(context).load(subCategoryList.get(position).getWap_banner_url()).into(holder.current_item_iv);
    }

    @Override
    public int getItemCount() {
        return subCategoryList.size();
    }

    class CurrentCategoryHolder extends RecyclerView.ViewHolder{
        ImageView current_item_iv;
        TextView current_item_tv;
        CurrentCategoryHolder(View itemView) {
            super(itemView);
            current_item_iv = itemView.findViewById(R.id.current_item_iv);
            current_item_tv = itemView.findViewById(R.id.current_item_tv);
        }
    }
}
