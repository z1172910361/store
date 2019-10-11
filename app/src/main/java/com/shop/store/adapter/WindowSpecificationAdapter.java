package com.shop.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.model.bean.ShopDetailBean;

import java.util.List;

/*
 *作者:SeeHeart 2019/10/7 19:40
 */
public class WindowSpecificationAdapter extends RecyclerView.Adapter<WindowSpecificationAdapter.WindowSpecificationHolder> {
    private List<ShopDetailBean.DataBeanX.SpecificationListBean> specificationList;
    private Context context;

    public WindowSpecificationAdapter(List<ShopDetailBean.DataBeanX.SpecificationListBean> specificationList, Context context) {
        this.specificationList = specificationList;
        this.context = context;
    }

    @NonNull
    @Override
    public WindowSpecificationHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_window_specification, viewGroup, false);
        return new WindowSpecificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WindowSpecificationHolder holder, int i) {
        holder.SpecificationTv.setText(specificationList.get(i).getName());

        List<ShopDetailBean.DataBeanX.SpecificationListBean.ValueListBean> valueList = specificationList.get(i).getValueList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.specificationListRv.setLayoutManager(linearLayoutManager);
        SpecificationValueAdapter specificationValueAdapter = new SpecificationValueAdapter(valueList, context);
        holder.specificationListRv.setAdapter(specificationValueAdapter);
    }

    @Override
    public int getItemCount() {
        return specificationList.size();
    }

    public class WindowSpecificationHolder extends RecyclerView.ViewHolder{
        TextView SpecificationTv;
        RecyclerView specificationListRv;
        public WindowSpecificationHolder(@NonNull View itemView) {
            super(itemView);
            SpecificationTv = itemView.findViewById(R.id.window_specificationList_tv);
            specificationListRv = itemView.findViewById(R.id.window_specificationList_rv);
        }
    }
}
