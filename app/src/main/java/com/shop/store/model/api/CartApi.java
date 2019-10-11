package com.shop.store.model.api;

import com.shop.store.model.bean.CartDataBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *作者:SeeHeart 2019/10/7 9:59
 */
public interface CartApi {

    @GET("cart/index")
    Flowable<CartDataBean> getCartData(@Query("uid")String uid);

    @POST("cart/delete")
    @FormUrlEncoded
    Flowable<CartDataBean> getCartDeleteData(@Field("uid")String uid,@Field("productIds") int productIds);
}
