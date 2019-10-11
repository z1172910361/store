package com.shop.store.interfaces.home.home_detail;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.BrandDetailBean;

/*
 *作者:SeeHeart 2019/9/23 14:33
 */
public interface BrandDetailContract {

    interface View extends IBaseView{
        void getBrandDetailReturn(BrandDetailBean detailBean);
    }

    interface Presenter extends IPersenter<View>{
        void getBrandDetail(int id);
    }

}
