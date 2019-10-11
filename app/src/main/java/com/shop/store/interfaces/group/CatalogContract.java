package com.shop.store.interfaces.group;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.CatalogCurrentBean;

/**
 * Created by 赵文才 on 2019/8/26 20:27.
 */

public interface CatalogContract {

    interface View extends IBaseView{
        void getCatalogReturn(CatalogCurrentBean catalogCurrentBean);
    }

    interface Persenter extends IPersenter<View>{
        void catalog(String id);
    }
}
