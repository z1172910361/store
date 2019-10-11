package com.shop.store.view.home.home_detail_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.shop.store.R;
import com.shop.store.adapter.ChannelVpAdapter;
import com.shop.store.base.BaseActivity;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.home_detail.ChannelContract;
import com.shop.store.model.bean.ChannelBean;
import com.shop.store.persenter.home.home_detail.ChannelPresenter;
import com.shop.store.view.home.fragment.ChannelListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/*
 *作者:SeeHeart 2019/9/23 14:29
 */
public class ChannelListActivity extends BaseActivity implements ChannelContract.View {

    @BindView(R.id.detail_tab)
    TabLayout detailTab;
    @BindView(R.id.brand_vp)
    ViewPager brandVp;

    private int brandId;
    private ChannelVpAdapter channelVpAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_channellist;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        brandId = intent.getIntExtra("brandId", 0);
    }

    @Override
    protected void initData() {
        ((ChannelPresenter) persenter).getChannelTab(brandId);
    }

    @Override
    protected IPersenter initPersenter() {
        return new ChannelPresenter();
    }

    @Override
    public void getChannelTabReturn(ChannelBean channelBean) {
        final List<ChannelBean.DataBean.BrotherCategoryBean> brotherCategory = channelBean.getData().getBrotherCategory();

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < brotherCategory.size(); i++) {
            ChannelListFragment channelListFragment = new ChannelListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", brotherCategory.get(i).getId());
            bundle.putString("name", brotherCategory.get(i).getName());
            bundle.putString("front", brotherCategory.get(i).getFront_name());
            channelListFragment.setArguments(bundle);
            fragments.add(channelListFragment);
        }
        channelVpAdapter = new ChannelVpAdapter(getSupportFragmentManager(), fragments, brotherCategory);
        brandVp.setAdapter(channelVpAdapter);
        detailTab.setupWithViewPager(brandVp);

        for (int i = 0; i < brotherCategory.size(); i++) {
            if (brandId == brotherCategory.get(i).getId()) {
                detailTab.getTabAt(i).select();
                break;
            }
        }

    }

}
