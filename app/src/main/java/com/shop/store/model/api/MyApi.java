package com.shop.store.model.api;


import com.shop.store.model.bean.IndexBean;
import com.shop.store.model.bean.ShopDetailBean;
import com.shop.store.model.bean.ShopDetailElseBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApi {

    @GET("index")
    Flowable<IndexBean> getIndexData();

    /**
     * 商品详情api
     * shop detail api
     *
     * @param id
     * @return
     */
    @GET("goods/detail")
    Flowable<ShopDetailBean> getShopData(@Query("id") int id);


    /**
     * 大家都在看api
     * shop detail else api
     *
     * @param id
     * @return
     */
    @GET("goods/related")
    Flowable<ShopDetailElseBean> getShopDetailElseData(@Query("id") int id);

    /**
     * 大家都在看api
     * shop detail else api
     *
     * @param uid,goodsId,productId,number
     * @return
     */
    @POST("cart/add")
    @FormUrlEncoded
    Flowable<ShopDetailBean> getAddCartShop(@Field("uid") String uid, @Field("goodsId") int goodsId, @Field("productId") int productId, @Field("number") int number);
}
