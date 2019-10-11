package com.shop.store.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shop.store.model.bean.CatalogBean;

import java.util.ArrayList;
import java.util.List;

public class VpAdapter extends FragmentPagerAdapter {
    private List<CatalogBean.DataBean.CategoryListBean> categoryList;
    private ArrayList<Fragment> fragments;

    public VpAdapter(FragmentManager fm, List<CatalogBean.DataBean.CategoryListBean> categoryList, ArrayList<Fragment> fragments) {
        super(fm);
        this.categoryList = categoryList;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categoryList.get(position).getName();
    }
}
