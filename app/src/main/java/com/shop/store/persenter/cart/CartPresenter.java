package com.shop.store.persenter.cart;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.cart.CartContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.CartDataBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/*
 *作者:SeeHeart 2019/10/7 10:05
 */
public class CartPresenter extends BasePersenter<CartContract.View> implements CartContract.Presenter {
    @Override
    public void getCart(String uid) {
        addSubscribe(HttpManager.getCartApi().getCartData(uid)
                .compose(RxUtils.<CartDataBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CartDataBean>(mView) {
                    @Override
                    public void onNext(CartDataBean cartDataBean) {
                        mView.getCartReturn(cartDataBean);
                    }
                }));
    }

    @Override
    public void getCartDelete(String uid, int productIds) {
        addSubscribe(HttpManager.getCartApi().getCartDeleteData(uid, productIds)
                .compose(RxUtils.<CartDataBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CartDataBean>(mView) {
                    @Override
                    public void onNext(CartDataBean cartDataBean) {
                        mView.getCartDeleteReturn(cartDataBean);
                    }
                }));
    }
}
