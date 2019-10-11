package com.shop.store.view.home.home_detail_activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.base.BaseActivity;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.home_detail.BrandDetailContract;
import com.shop.store.model.bean.BrandDetailBean;
import com.shop.store.persenter.home.home_detail.BrandDetailPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
 *作者:SeeHeart 2019/9/24 17:02
 */
public class BrandDetailActivity extends BaseActivity implements BrandDetailContract.View {

    @BindView(R.id.brand_detail_iv)
    ImageView brandDetailIv;
    @BindView(R.id.brand_detail_tv)
    TextView brandDetailTv;
    @BindView(R.id.brand_detail_rv)
    RecyclerView brandDetailRv;
    @BindView(R.id.brand_detail_finish)
    TextView brandDetailFinish;
    private List<BrandDetailBean.DataBean.BrandBean> list;
    private int id;

    @Override
    protected int getLayout() {
        return R.layout.activity_branddetail;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        brandDetailRv.setLayoutManager(new GridLayoutManager(this, 2));


    }

    @Override
    protected void initData() {
        ((BrandDetailPresenter)persenter).getBrandDetail(id);
    }

    @Override
    protected IPersenter initPersenter() {
        return new BrandDetailPresenter();
    }

    @Override
    public void getBrandDetailReturn(BrandDetailBean detailBean) {
        brandDetailTv.setText(detailBean.getData().getBrand().getSimple_desc());
        Glide.with(this).load(detailBean.getData().getBrand().getApp_list_pic_url()).into(brandDetailIv);
    }

    @OnClick(R.id.brand_detail_finish)
    public void onViewClicked() {
        finish();
    }
}
