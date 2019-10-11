package com.shop.store.interfaces.detail;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.BrandDetailBean;

/*
 *作者:SeeHeart 2019/9/23 14:33
 */
public interface DetailContract {

    interface View extends IBaseView{
        void getDetailListReturn(BrandDetailBean detailBean);
    }

    interface Presenter extends IPersenter<View>{
        void getDetailList(int id);
    }

}
