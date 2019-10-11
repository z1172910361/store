package com.shop.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.model.bean.ShopDetailBean;

import java.util.List;

/*
 *作者:SeeHeart 2019/9/27 21:00
 */
public class ShopDetailParamsAdapter extends RecyclerView.Adapter<ShopDetailParamsAdapter.ShopDetailParamsHolder> {

    private List<ShopDetailBean.DataBeanX.AttributeBean> paramsList;
    private Context context;

    public ShopDetailParamsAdapter(List<ShopDetailBean.DataBeanX.AttributeBean> paramsList, Context context) {
        this.paramsList = paramsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopDetailParamsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shopdetail_params, viewGroup, false);
        return new ShopDetailParamsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopDetailParamsHolder shopDetailParamsHolder, int i) {
        shopDetailParamsHolder.nameTv.setText(paramsList.get(i).getName());
        shopDetailParamsHolder.valueTv.setText(paramsList.get(i).getValue());
    }

    @Override
    public int getItemCount() {
        return paramsList.size();
    }

    public class ShopDetailParamsHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView valueTv;
        public ShopDetailParamsHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.shopDetail_params_nameTv);
            valueTv = itemView.findViewById(R.id.shopDetail_params_valueTv);
        }
    }
}
