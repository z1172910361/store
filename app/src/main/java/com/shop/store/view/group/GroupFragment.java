package com.shop.store.view.group;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.shop.store.R;
import com.shop.store.adapter.VpAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.group.GroupContract;
import com.shop.store.model.bean.CatalogBean;
import com.shop.store.persenter.group.GroupPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class GroupFragment extends BaseFragment implements GroupContract.View {


    @BindView(R.id.verticalTab)
    VerticalTabLayout verticalTab;
    @BindView(R.id.group_vp)
    ViewPager groupVp;

    @Override
    protected int getLayout() {
        return R.layout.fragment_group;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        ((GroupPersenter)persenter).group();
    }

    @Override
    protected IPersenter createPersenter() {
        return new GroupPersenter();
    }

    @Override
    public void getGroupReturn(CatalogBean catalogBean) {
        List<CatalogBean.DataBean.CategoryListBean> categoryList = catalogBean.getData().getCategoryList();
        initFragment(categoryList);
    }

    private void initFragment(List<CatalogBean.DataBean.CategoryListBean> categoryList) {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            CatalogFragment catalogFragment = new CatalogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id",categoryList.get(i).getId());
            catalogFragment.setArguments(bundle);
            fragments.add(catalogFragment);
        }

        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(),categoryList, fragments);
        groupVp.setAdapter(vpAdapter);
        verticalTab.setupWithViewPager(groupVp);
    }

    @Override
    public void showErrMsg(String err) {
        Log.i("See", "showErrMsg: "+err);
    }
}
