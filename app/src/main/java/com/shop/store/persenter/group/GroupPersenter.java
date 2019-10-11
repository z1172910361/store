package com.shop.store.persenter.group;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.group.GroupContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.CatalogBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/**
 * Created by 赵文才 on 2019/8/26 19:48.
 */

public class GroupPersenter extends BasePersenter<GroupContract.View> implements GroupContract.Persenter {
    @Override
    public void group() {
        addSubscribe(HttpManager.getGroupApi().requestData()
        .compose(RxUtils.<CatalogBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<CatalogBean>(mView) {
            @Override
            public void onNext(CatalogBean catalogBean) {
                mView.getGroupReturn(catalogBean);
            }
        }));
    }
}
