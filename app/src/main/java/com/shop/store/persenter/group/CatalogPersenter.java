package com.shop.store.persenter.group;

import com.shop.store.base.BaseFragment;
import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.group.CatalogContract;
import com.shop.store.interfaces.group.GroupContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.CatalogCurrentBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/**
 * Created by 赵文才 on 2019/8/26 20:34.
 */

public class CatalogPersenter extends BasePersenter<CatalogContract.View> implements CatalogContract.Persenter{

    @Override
    public void catalog(String id) {
        addSubscribe(HttpManager.getCatalogApi().requestClassifyData(id)
                    .compose(RxUtils.<CatalogCurrentBean>rxScheduler())
                    .subscribeWith(new CommonSubscriber<CatalogCurrentBean>(mView) {
                        @Override
                        public void onNext(CatalogCurrentBean catalogCurrentBean) {
                            mView.getCatalogReturn(catalogCurrentBean);
                        }
                    }));
    }
}
