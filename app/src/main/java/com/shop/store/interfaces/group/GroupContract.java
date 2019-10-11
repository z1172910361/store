package com.shop.store.interfaces.group;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.CatalogBean;

/**
 * Created by 赵文才 on 2019/8/26 19:50.
 */

public interface GroupContract {

    interface View extends IBaseView{
        void getGroupReturn(CatalogBean catalogBean);
    }

    interface Persenter extends IPersenter<View>{
        void group();
    }
}
