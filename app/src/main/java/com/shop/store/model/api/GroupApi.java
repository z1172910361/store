package com.shop.store.model.api;

import com.shop.store.model.bean.CatalogBean;
import com.shop.store.model.bean.CatalogCurrentBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 赵文才 on 2019/8/26 19:43.
 */

public interface GroupApi {
    //https://cdwan.cn/api/catalog/index
    @GET("catalog/index")
    Flowable<CatalogBean> requestData();

}
