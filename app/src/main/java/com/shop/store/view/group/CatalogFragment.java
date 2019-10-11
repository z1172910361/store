package com.shop.store.view.group;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.adapter.CurrentCategoryAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.group.CatalogContract;
import com.shop.store.model.bean.CatalogCurrentBean;
import com.shop.store.persenter.group.CatalogPersenter;

import java.util.List;

import butterknife.BindView;

public class CatalogFragment extends BaseFragment implements CatalogContract.View {


    @BindView(R.id.item_header_iv)
    ImageView itemHeaderIv;
    @BindView(R.id.item_header_tv)
    TextView itemHeaderTv;
    @BindView(R.id.classify_tv)
    TextView classifyTv;
    @BindView(R.id.classify_rv)
    RecyclerView classifyRv;
    private int page;

    @Override
    protected int getLayout() {
        return R.layout.fragment_catalog;
    }

    @Override
    protected void initView(View view) {
        Bundle bundle = getArguments();
        page = bundle.getInt("id");
        classifyRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
    }

    @Override
    protected void initData() {
        String id = String.valueOf(page);
        ((CatalogPersenter) persenter).catalog(id);
    }

    @Override
    protected IPersenter createPersenter() {
        return new CatalogPersenter();
    }

    @Override
    public void showErrMsg(String err) {
        Log.i("See", "showErrMsg: " + err);
    }

    @Override
    public void getCatalogReturn(CatalogCurrentBean catalogCurrentBean) {
        CatalogCurrentBean.DataBean.CurrentCategoryBean currentCategory = catalogCurrentBean.getData().getCurrentCategory();
        List<CatalogCurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = currentCategory.getSubCategoryList();

        Glide.with(this).load(currentCategory.getWap_banner_url()).into(itemHeaderIv);
        itemHeaderTv.setText(currentCategory.getFront_name());
        classifyTv.setText("—— "+currentCategory.getName()+"分类 ——");

        CurrentCategoryAdapter currentCategoryAdapter = new CurrentCategoryAdapter(subCategoryList, getActivity());
        classifyRv.setAdapter(currentCategoryAdapter);
    }

}
