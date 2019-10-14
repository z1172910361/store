package com.shop.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.model.bean.CartDataBean;
import com.shop.store.view.cart.CartFragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 *作者:SeeHeart 2019/9/22 16:00
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    private List<CartDataBean.DataBean.CartListBean> list;
    private Context context;
    private int number;

    public CartAdapter(List<CartDataBean.DataBean.CartListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public static HashSet<Integer> positions = new HashSet<>();

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_cart_item, viewGroup, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartHolder cartHolder, final int i) {

        CartDataBean.DataBean.CartListBean bean = list.get(i);

        number = list.get(i).getNumber();
        Glide.with(context).load(list.get(i).getList_pic_url()).into(cartHolder.shopIv);
        cartHolder.titleTv.setText(list.get(i).getGoods_name());
        cartHolder.countTv.setText("×" + number);
        cartHolder.itemCount.setText(number + "");
        cartHolder.priceTv.setText("￥" + list.get(i).getRetail_price());
        cartHolder.cb.setChecked(list.get(i).isSelect);
        if (CartFragment.COUNT_VISIABLE) {
            cartHolder.itemCount.setTag(i);
            cartHolder.itemCount.setText(number + "");
            cartHolder.itemCount.setVisibility(View.VISIBLE);
            cartHolder.addCount.setVisibility(View.VISIBLE);
            cartHolder.substractCount.setVisibility(View.VISIBLE);
            cartHolder.titleTv.setVisibility(View.GONE);
            cartHolder.priceTv.setVisibility(View.GONE);
            cartHolder.countTv.setText("已选择：>");
            cartHolder.addCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) cartHolder.itemCount.getTag();
                    number = list.get(tag).getNumber();
                    number++;
                    list.get(tag).setNumber(number);
                    cartHolder.itemCount.setText(number + "");
                }
            });

            cartHolder.substractCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) cartHolder.itemCount.getTag();
                    number = list.get(tag).getNumber();
                    if (number > 1) {
                        number--;
                        list.get(tag).setNumber(number);
                        cartHolder.itemCount.setText(number + "");
                    }
                }
            });

        } else {
            list.get(i).setNumber(number);
            cartHolder.countTv.setText("×" + number);

            cartHolder.itemCount.setVisibility(View.GONE);
            cartHolder.addCount.setVisibility(View.GONE);
            cartHolder.substractCount.setVisibility(View.GONE);
            cartHolder.titleTv.setVisibility(View.VISIBLE);
            cartHolder.priceTv.setVisibility(View.VISIBLE);
        }

        cartHolder.cb.setTag(bean);
        cartHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = cartHolder.cb.isChecked();

                CartDataBean.DataBean.CartListBean tag = (CartDataBean.DataBean.CartListBean) v.getTag();

                tag.isSelect = checked;
                if (cartAdapterPriceReturn != null) {
                    cartAdapterPriceReturn.selectClick();
                }
            }
        });

        cartHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (!positions.contains(i))
                        positions.add(i);
                    int priceAmount = list.get(i).getRetail_price() * list.get(i).getNumber();
                    if (priceAmount != 0)
                        cartAdapterPriceReturn.onCartAdapterPriceReturn(isChecked, priceAmount);
                } else {
                    if (positions.contains(i))
                        positions.remove(i);

                    int priceAmount = list.get(i).getRetail_price() * list.get(i).getNumber();
                    if (priceAmount != 0)
                        cartAdapterPriceReturn.onCartAdapterPriceReturn(isChecked, priceAmount);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        CheckBox cb;
        ImageView shopIv;
        TextView titleTv;
        TextView priceTv;
        TextView countTv;
        TextView addCount;
        TextView substractCount;
        TextView itemCount;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cart_item_cb);
            shopIv = itemView.findViewById(R.id.cart_item_iv);
            titleTv = itemView.findViewById(R.id.cart_item_title_tv);
            priceTv = itemView.findViewById(R.id.cart_item_price_tv);
            countTv = itemView.findViewById(R.id.cart_item_count_tv);
            addCount = itemView.findViewById(R.id.item_count_add);
            substractCount = itemView.findViewById(R.id.item_count_subtract);
            itemCount = itemView.findViewById(R.id.item_countTv);


        }
    }

    public interface CartAdapterPriceReturn {
        void onCartAdapterPriceReturn(boolean check, int price);

        void selectClick();
    }

    private CartAdapterPriceReturn cartAdapterPriceReturn;

    public void setCartAdapterPriceReturn(CartAdapterPriceReturn cartAdapterPriceReturn) {
        this.cartAdapterPriceReturn = cartAdapterPriceReturn;
    }
}
