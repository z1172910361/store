package com.shop.store.interfaces.home.home_detail;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.ChannelListBean;

/*
 *作者:SeeHeart 2019/9/24 13:54
 */
public interface ChannelListContract {
    interface View extends IBaseView {
        void getChannelListReturn(ChannelListBean channelListBean);
    }

    interface Presenter extends IPersenter<ChannelListContract.View> {
        void getChannelList(int id, int page, int size);
    }
}
