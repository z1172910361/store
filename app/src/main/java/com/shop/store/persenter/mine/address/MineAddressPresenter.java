package com.shop.store.persenter.mine.address;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.mine.address.MineAddressContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.AddressBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/*
 *作者:SeeHeart 2019/10/9 14:29
 */
public class MineAddressPresenter extends BasePersenter<MineAddressContract.View> implements MineAddressContract.Presenter {
    @Override
    public void getMineAddress(String uid) {
        addSubscribe(HttpManager.getMineApi().getMineAddress(uid)
                .compose(RxUtils.<AddressBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AddressBean>(mView) {
                    @Override
                    public void onNext(AddressBean addressBean) {
                        mView.getMineAddressReturn(addressBean);
                    }
                }));
    }

    @Override
    public void getMineAddressClick(String uid,int id) {
        addSubscribe(HttpManager.getMineApi().getMineAddressClick(uid,id)
        .compose(RxUtils.<AddressBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<AddressBean>(mView) {
            @Override
            public void onNext(AddressBean addressBean) {
                mView.getMineAddressClickReturn(addressBean);
            }
        }));
    }
}
