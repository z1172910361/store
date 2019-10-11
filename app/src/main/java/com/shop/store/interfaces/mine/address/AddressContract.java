package com.shop.store.interfaces.mine.address;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.AddressBean;

/*
 *作者:SeeHeart 2019/10/9 10:30
 */
public interface AddressContract {

    interface View extends IBaseView{
        void getAddressInfoReturn(AddressBean addressBean);
    }

    interface Presenter extends IPersenter<View>{
        /**
         *
         * @param id 收获地址id
         * @param name 姓名
         * @param uid uid
         * @param mobile 手机号
         * @param province 省份
         * @param city 城市
         * @param district 区县
         * @param address 详细地址
         * @param isDefault 是否默认
         */
        void getAddressInfo(String id,String uid,String name,String mobile,String province,String city,String district,String address,int isDefault);
    }
}
