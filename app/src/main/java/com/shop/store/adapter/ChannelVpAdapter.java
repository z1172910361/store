package com.shop.store.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shop.store.model.bean.ChannelBean;

import java.util.List;

/*
 *作者:SeeHeart 2019/9/24 11:52
 */
public class ChannelVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<ChannelBean.DataBean.BrotherCategoryBean> brotherCategory;

    public ChannelVpAdapter(FragmentManager fm, List<Fragment> fragments, List<ChannelBean.DataBean.BrotherCategoryBean> brotherCategory) {
        super(fm);
        this.fragments = fragments;
        this.brotherCategory = brotherCategory;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return brotherCategory.get(position).getName();
    }
}
