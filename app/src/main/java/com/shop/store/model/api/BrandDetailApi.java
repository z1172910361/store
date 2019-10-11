package com.shop.store.model.api;

import com.shop.store.model.bean.BrandDetailBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *作者:SeeHeart 2019/9/23 14:35
 */
public interface BrandDetailApi {
    @GET("brand/detail")
    Flowable<BrandDetailBean> getDetailData(@Query("id")int id);

}
