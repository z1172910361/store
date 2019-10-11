package com.shop.store.interfaces.home.home_detail;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.ChannelBean;

/*
 *作者:SeeHeart 2019/9/23 17:06
 */
public interface ChannelContract {

    interface View extends IBaseView{
        void getChannelTabReturn(ChannelBean channelBean);
    }

    interface Presenter extends IPersenter<View>{
        void getChannelTab(int id);
    }
}
