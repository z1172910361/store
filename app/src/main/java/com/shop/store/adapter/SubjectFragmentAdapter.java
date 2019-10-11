package com.shop.store.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.model.bean.SubjectBean;

import java.util.List;

/**
 * Created by 赵文才 on 2019/8/27 14:30.
 */

public class SubjectFragmentAdapter extends RecyclerView.Adapter<SubjectFragmentAdapter.SubjectFragmentHolder> {
    private List<SubjectBean.DataBeanX.DataBean> data;
    private Context context;

    public SubjectFragmentAdapter(List<SubjectBean.DataBeanX.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public SubjectFragmentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_subjectfragment_item, viewGroup, false);
        return new SubjectFragmentHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SubjectFragmentHolder subjectFragmentHolder, int i) {
        subjectFragmentHolder.titletv.setText(data.get(i).getTitle());
        subjectFragmentHolder.subtitletv.setText(data.get(i).getSubtitle());
        subjectFragmentHolder.pricetv.setText(data.get(i).getPrice_info()+"元起");

        Log.i("See", "onBindViewHolder: "+data.get(i).getScene_pic_url());

        Glide.with(context).load(data.get(i).getScene_pic_url()).into(subjectFragmentHolder.iv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SubjectFragmentHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView titletv;
        TextView subtitletv;
        TextView pricetv;
        public SubjectFragmentHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.subjectFragment_item_iv);
            titletv = itemView.findViewById(R.id.subjectFragment_item_titletv);
            subtitletv = itemView.findViewById(R.id.subjectFragment_item_subtitletv);
            pricetv = itemView.findViewById(R.id.subjectFragment_item_pricetv);
        }
    }
}
