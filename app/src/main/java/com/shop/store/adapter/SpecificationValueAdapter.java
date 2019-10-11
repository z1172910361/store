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
 *作者:SeeHeart 2019/10/7 19:47
 */
public class SpecificationValueAdapter extends RecyclerView.Adapter<SpecificationValueAdapter.SpecificationValueHolder> {
    private List<ShopDetailBean.DataBeanX.SpecificationListBean.ValueListBean> valueList;
    private Context context;

    public SpecificationValueAdapter(List<ShopDetailBean.DataBeanX.SpecificationListBean.ValueListBean> valueList, Context context) {
        this.valueList = valueList;
        this.context = context;
    }

    @NonNull
    @Override
    public SpecificationValueHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_specification_value, viewGroup, false);
        return new SpecificationValueHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecificationValueHolder specificationValueHolder, int i) {
        specificationValueHolder.tv.setText(valueList.get(i).getValue());
    }

    @Override
    public int getItemCount() {
        return valueList.size();
    }

    public class SpecificationValueHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public SpecificationValueHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.specification_vaule_tv);
        }
    }
}
