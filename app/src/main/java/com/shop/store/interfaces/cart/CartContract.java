package com.shop.store.interfaces.cart;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.CartDataBean;

/*
 *作者:SeeHeart 2019/10/7 9:51
 */
public interface CartContract {

    interface View extends IBaseView{
        void getCartReturn(CartDataBean cartDataBean);
        void getCartDeleteReturn(CartDataBean cartDataBean);
    }

    interface Presenter extends IPersenter<View>{
        void getCart(String uid);
        void getCartDelete(String uid,int productIds);
    }

}
