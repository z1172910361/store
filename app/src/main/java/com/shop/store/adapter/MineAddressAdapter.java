package com.shop.store.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.model.bean.AddressBean;

import java.util.List;

/*
 *作者:SeeHeart 2019/10/9 14:36
 */
public class MineAddressAdapter extends RecyclerView.Adapter<MineAddressAdapter.MineAddressHolder> {
    private List<AddressBean.DataBean> addressList;
    private Context context;

    public MineAddressAdapter(List<AddressBean.DataBean> addressList, Context context) {
        this.addressList = addressList;
        this.context = context;
    }

    @NonNull
    @Override
    public MineAddressHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mine_address, viewGroup, false);
        return new MineAddressHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MineAddressHolder mineAddressHolder, final int i) {
        mineAddressHolder.nameTv.setText(addressList.get(i).getName());
        mineAddressHolder.phoneTv.setText(addressList.get(i).getMobile());
        mineAddressHolder.optionsTv.setText(addressList.get(i).getProvince()+"  "+addressList.get(i).getCity()+"  "+addressList.get(i).getArea());
        mineAddressHolder.detailTv.setText(addressList.get(i).getAddress());
        int is_default = addressList.get(i).getIs_default();
        if (is_default == 0){
            mineAddressHolder.defaultTv.setText("");
            mineAddressHolder.defaultTv.setVisibility(View.GONE);
        }else if (is_default == 1){
            mineAddressHolder.defaultTv.setText("默认");
            mineAddressHolder.defaultTv.setVisibility(View.VISIBLE);
        }

        mineAddressHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mineAddressOnClick!=null)
                    mineAddressOnClick.mineAddressOnItemClick(i);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    public class MineAddressHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView phoneTv;
        TextView optionsTv;
        TextView detailTv;
        TextView defaultTv;

        public MineAddressHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.item_address_name);
            phoneTv = itemView.findViewById(R.id.item_address_phone);
            optionsTv = itemView.findViewById(R.id.item_address_options);
            detailTv = itemView.findViewById(R.id.item_address_detail);
            defaultTv = itemView.findViewById(R.id.item_address_default);

        }
    }

    public interface MineAddressOnClick{
        void mineAddressOnItemClick(int position);
    }

    private MineAddressOnClick mineAddressOnClick;

    public void setMineAddressOnClick(MineAddressOnClick mineAddressOnClick) {
        this.mineAddressOnClick = mineAddressOnClick;
    }
}
