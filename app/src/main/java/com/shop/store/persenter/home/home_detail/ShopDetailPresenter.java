package com.shop.store.persenter.home.home_detail;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.home_detail.ShopDetailContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.ShopDetailBean;
import com.shop.store.model.bean.ShopDetailElseBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/*
 *作者:SeeHeart 2019/9/27 16:07
 */
public class ShopDetailPresenter extends BasePersenter<ShopDetailContract.View> implements ShopDetailContract.Presenter {
    @Override
    public void getShopDetailList(int id) {
        addSubscribe(HttpManager.getMyApi().getShopData(id)
                .compose(RxUtils.<ShopDetailBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ShopDetailBean>(mView) {
                    @Override
                    public void onNext(ShopDetailBean shopDetailBean) {
                        mView.getShopDetailReturn(shopDetailBean);
                    }
                }));
    }

    @Override
    public void getShopDetailElseList(int id) {
        addSubscribe(HttpManager.getMyApi().getShopDetailElseData(id)
                .compose(RxUtils.<ShopDetailElseBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ShopDetailElseBean>(mView) {
                    @Override
                    public void onNext(ShopDetailElseBean shopDetailElseBean) {
                        mView.getShopDetailElseReturn(shopDetailElseBean);
                    }
                }));
    }

    @Override
    public void getAddCartShop(String uid, int goodsId, int productId, int number) {
        addSubscribe(HttpManager.getMyApi().getAddCartShop(uid,goodsId,productId,number)
        .compose(RxUtils.<ShopDetailBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<ShopDetailBean>(mView) {
            @Override
            public void onNext(ShopDetailBean shopDetailBean) {
                mView.getAddCartShopReturn(shopDetailBean);
            }
        }));
    }
}
