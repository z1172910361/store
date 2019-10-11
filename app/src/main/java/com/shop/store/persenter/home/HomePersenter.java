package com.shop.store.persenter.home;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.IndexBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/**
 * Created by 赵文才 on 2019/8/26 16:17.
 */

public class HomePersenter extends BasePersenter<HomeContract.View> implements HomeContract.Persenter {

    @Override
    public void home() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView) {
                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.getHomeReturn(indexBean);
                    }
                }));
    }
}
