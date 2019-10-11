package com.shop.store.view.mine;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.persenter.home.HomePersenter;
import com.shop.store.persenter.mine.address.MineAddressPresenter;
import com.shop.store.view.mine.activity.MineActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment {


    @BindView(R.id.mine_header_iv)
    ImageView mineHeaderIv;
    @BindView(R.id.mine_petName_tv)
    TextView minePetNameTv;
    @BindView(R.id.mine_info)
    RelativeLayout mineInfo;
    @BindView(R.id.mine_order)
    LinearLayout mineOrder;
    @BindView(R.id.mine_discounts)
    LinearLayout mineDiscounts;
    @BindView(R.id.mine_gift)
    LinearLayout mineGift;
    @BindView(R.id.mine_collect)
    LinearLayout mineCollect;
    @BindView(R.id.mine_track)
    LinearLayout mineTrack;
    @BindView(R.id.mine_vipWeal)
    LinearLayout mineVipWeal;
    @BindView(R.id.mine_address)
    LinearLayout mineAddress;
    @BindView(R.id.mine_username)
    LinearLayout mineUsername;
    @BindView(R.id.mine_service)
    LinearLayout mineService;
    @BindView(R.id.mine_help)
    LinearLayout mineHelp;
    @BindView(R.id.mine_idea)
    LinearLayout mineIdea;

    @Override
    public void showErrMsg(String err) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return new MineAddressPresenter();
    }

    @OnClick({R.id.mine_info, R.id.mine_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mine_info:
                break;
            case R.id.mine_address:
                Intent intent = new Intent(getActivity(), MineActivity.class);
                startActivity(intent);
                break;
        }
    }
}
