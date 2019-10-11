package com.shop.store.interfaces.home.home_detail;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.ShopDetailBean;
import com.shop.store.model.bean.ShopDetailElseBean;

/*
 *作者:SeeHeart 2019/9/27 16:08
 */
public interface ShopDetailContract {

    interface View extends IBaseView{
        void getShopDetailReturn(ShopDetailBean shopDetailBean);

        void getShopDetailElseReturn(ShopDetailElseBean shopDetailElseBean);

        void getAddCartShopReturn(ShopDetailBean shopDetailBean);
    }

    interface Presenter extends IPersenter<View>{
        void getShopDetailList(int id);

        void getShopDetailElseList(int id);

        void getAddCartShop(String uid,int goodsId,int productId,int number);
    }

}
