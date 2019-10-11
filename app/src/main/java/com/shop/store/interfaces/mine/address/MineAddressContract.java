package com.shop.store.interfaces.mine.address;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.AddressBean;

/*
 *作者:SeeHeart 2019/10/9 14:26
 */
public interface MineAddressContract {

    interface View extends IBaseView{
        void getMineAddressReturn(AddressBean addressBean);
        void getMineAddressClickReturn(AddressBean addressBean);
    }

    interface Presenter extends IPersenter<View>{
        void getMineAddress(String uid);
        void getMineAddressClick(String uid, int id);
    }
}
