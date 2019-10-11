package com.shop.store.persenter.home.home_detail;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.home_detail.ChannelContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.ChannelBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/*
 *作者:SeeHeart 2019/9/23 17:09
 */
public class ChannelPresenter extends BasePersenter<ChannelContract.View> implements ChannelContract.Presenter {
    @Override
    public void getChannelTab(int id) {
        addSubscribe(HttpManager.getBrandListApi().getBrandTabList(id)
        .compose(RxUtils.<ChannelBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<ChannelBean>(mView) {
            @Override
            public void onNext(ChannelBean channelBean) {
                mView.getChannelTabReturn(channelBean);
            }
        }));
    }


}
