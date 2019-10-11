package com.shop.store.persenter.home.home_detail;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.home.home_detail.ChannelListContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.ChannelListBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/*
 *作者:SeeHeart 2019/9/24 13:55
 */
public class ChannelListPresenter extends BasePersenter<ChannelListContract.View> implements ChannelListContract.Presenter {
    @Override
    public void getChannelList(int id, int page, int size) {
        addSubscribe(HttpManager.getBrandListApi().getBrandList(id,page,size)
                .compose(RxUtils.<ChannelListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ChannelListBean>(mView) {
                    @Override
                    public void onNext(ChannelListBean channelListBean) {
                        mView.getChannelListReturn(channelListBean);
                    }
                }));
    }
}
