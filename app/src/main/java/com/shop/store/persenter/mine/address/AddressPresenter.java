package com.shop.store.persenter.mine.address;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.mine.address.AddressContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.AddressBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/*
 *作者:SeeHeart 2019/10/9 11:10
 */
public class AddressPresenter extends BasePersenter<AddressContract.View> implements AddressContract.Presenter {
    @Override
    public void getAddressInfo(String id, String uid, String name, String mobile, String province, String city, String district, String address, int isDefault) {
        addSubscribe(HttpManager.getMineApi().getAddressInfo(id, uid, name, mobile, province, city, district, address, isDefault)
                .compose(RxUtils.<AddressBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<AddressBean>(mView) {
                    @Override
                    public void onNext(AddressBean addressBean) {
                        mView.getAddressInfoReturn(addressBean);
                    }
                }));
    }

}
