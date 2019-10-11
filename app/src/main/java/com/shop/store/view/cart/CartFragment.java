package com.shop.store.view.cart;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.store.R;
import com.shop.store.adapter.CartAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.constants.Constant;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.cart.CartContract;
import com.shop.store.model.bean.CartDataBean;
import com.shop.store.persenter.cart.CartPresenter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CartFragment extends BaseFragment implements CartContract.View, CartAdapter.CartAdapterPriceReturn {

    @BindView(R.id.cart_rv)
    RecyclerView cartRv;
    @BindView(R.id.check_all_cb)
    CheckBox checkAllCb;
    @BindView(R.id.total_price_tv)
    TextView totalPriceTv;
    @BindView(R.id.edit_tv)
    TextView editTv;
    @BindView(R.id.order_btn)
    Button orderBtn;
    private List<CartDataBean.DataBean.CartListBean> list;
    private CartAdapter cartAdapter;

    public static boolean cbIsChecked = false;
    public static boolean COUNT_VISIABLE = false;
    private int priceSum = 0;
    private int countSum = 0;

    @Override
    public void showErrMsg(String err) {
        Log.i("See", "showErrMsg: " + err);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void initView(View view) {

        cartRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        cartAdapter = new CartAdapter(list, getActivity());
        cartRv.setAdapter(cartAdapter);

    }

    @Override
    protected void initData() {

        ((CartPresenter) persenter).getCart(Constant.UID);
    }

    @Override
    protected IPersenter createPersenter() {
        return new CartPresenter();
    }

    @Override
    public void getCartReturn(CartDataBean cartDataBean) {
        List<CartDataBean.DataBean.CartListBean> cartList = cartDataBean.getData().getCartList();
        list.addAll(cartList);
        cartAdapter.notifyDataSetChanged();
        cartAdapter.setCartAdapterPriceReturn(this);
    }

    @Override
    public void getCartDeleteReturn(CartDataBean cartDataBean) {
        Log.i("See", "getCartDeleteReturn: ");
    }

    @OnClick({R.id.check_all_cb, R.id.edit_tv, R.id.order_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.check_all_cb:
                if (checkAllCb.isChecked()) {
                    priceSum = 0;
                    countSum = 0;
                    cbIsChecked = true;
                    if (list != null && !list.isEmpty()) {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setChecked(1);
                            int number = list.get(i).getNumber();
                            int retail_price = list.get(i).getRetail_price();
                            priceSum += number * retail_price;
                            countSum += number;
                        }
                    }
                } else {
                    cbIsChecked = false;
                    priceSum = 0;
                    countSum = 0;
                }
                cartAdapter.notifyDataSetChanged();
                checkAllCb.setText("全选(" + countSum + ")");
                totalPriceTv.setText("￥" + priceSum);
                break;
            case R.id.edit_tv:
                String edit = editTv.getText().toString();
                if (edit.equals("编辑")) {
                    COUNT_VISIABLE = true;
                    editTv.setText("完成");
                    orderBtn.setText("删除");
                } else {
                    COUNT_VISIABLE = false;
                    editTv.setText("编辑");
                    orderBtn.setText("下单");
                }
                cartAdapter.notifyDataSetChanged();
                break;

            case R.id.order_btn:
                String order = orderBtn.getText().toString();
                if (order.equals("删除")) {
                    HashSet<Integer> positions = CartAdapter.positions;
                    if (positions != null && !positions.isEmpty()) {
                        for (Integer position:positions) {
                            ((CartPresenter) persenter).getCartDelete(Constant.UID, list.get(position).getProduct_id());
                        }
                        Toast.makeText(context, "删除完成", Toast.LENGTH_SHORT).show();
                    }
                }
                ((CartPresenter) persenter).getCart(Constant.UID);
                cartAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onCartAdapterPriceReturn(boolean check, int price) {

        if (check) {
            priceSum = 0;
            priceSum += price;
            if (priceSum >= 0)
                totalPriceTv.setText("￥" + priceSum);
        } else {
            priceSum -= price;
            if (priceSum >= 0)
                totalPriceTv.setText("￥" + priceSum);
        }
    }
}
