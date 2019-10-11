package com.shop.store.interfaces.home;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.IndexBean;

/**
 * Created by 赵文才 on 2019/8/26 16:19.
 */

public interface HomeContract {

    interface View extends IBaseView{
        void getHomeReturn(IndexBean indexBean);
    }

    interface Persenter extends IPersenter<View>{
        void home();
    }
}
