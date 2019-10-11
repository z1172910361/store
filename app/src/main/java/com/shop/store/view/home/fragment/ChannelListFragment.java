package com.shop.store.view.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.adapter.ChannelListAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.home_detail.ChannelListContract;
import com.shop.store.model.bean.ChannelListBean;
import com.shop.store.persenter.home.home_detail.ChannelListPresenter;
import com.shop.store.view.home.home_detail_activity.ShopDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/*
 *作者:SeeHeart 2019/9/24 11:49
 */
public class ChannelListFragment extends BaseFragment implements ChannelListContract.View, ChannelListAdapter.ChannelOnClick {
    @BindView(R.id.detail_rv)
    RecyclerView detailRv;

    @BindView(R.id.detail_name_tv)
    TextView detailNameTv;
    @BindView(R.id.detail_front_tv)
    TextView detailFrontTv;
    private List<ChannelListBean.DataBeanX.GoodsListBean> list;
    private ChannelListAdapter channelListAdapter;
    private int id;
    private String front;
    private String name;

    @Override
    protected int getLayout() {
        return R.layout.fragment_channellist;
    }

    @Override
    protected void initView(View view) {

        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        name = bundle.getString("name");
        front = bundle.getString("front");

        detailRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        list = new ArrayList<>();
        channelListAdapter = new ChannelListAdapter(list, getActivity());
        detailRv.setAdapter(channelListAdapter);
    }

    @Override
    protected void initData() {
        ((ChannelListPresenter) persenter).getChannelList(id, 1, 10);
        detailNameTv.setText(name);
        detailFrontTv.setText(front);
    }

    @Override
    protected IPersenter createPersenter() {
        return new ChannelListPresenter();
    }

    @Override
    public void getChannelListReturn(ChannelListBean channelListBean) {
        List<ChannelListBean.DataBeanX.GoodsListBean> dataBeanList = channelListBean.getData().getGoodsList();
        list.addAll(dataBeanList);
        channelListAdapter.notifyDataSetChanged();
        channelListAdapter.setChannelOnClick(this);
    }

    @Override
    public void showErrMsg(String err) {
        Log.i("See", "showErrMsg: ");
    }

    @Override
    public void channelOnItemClickListener(int position) {
        ChannelListBean.DataBeanX.GoodsListBean goodsListBean = list.get(position);
        Intent intent = new Intent(getActivity(), ShopDetailActivity.class);
        intent.putExtra("id",goodsListBean.getId());
        startActivity(intent);
    }
}
