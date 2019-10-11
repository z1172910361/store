package com.shop.store.persenter.home.home_detail;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.home_detail.BrandDetailContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.BrandDetailBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/*
 *作者:SeeHeart 2019/9/24 18:48
 */
public class BrandDetailPresenter extends BasePersenter<BrandDetailContract.View> implements BrandDetailContract.Presenter {
    @Override
    public void getBrandDetail(int id) {
        addSubscribe(HttpManager.getBrandDetailApi().getDetailData(id)
        .compose(RxUtils.<BrandDetailBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<BrandDetailBean>(mView) {
            @Override
            public void onNext(BrandDetailBean brandDetailBean) {
                mView.getBrandDetailReturn(brandDetailBean);
            }
        }));
    }
}
