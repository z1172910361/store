package com.shop.store.model.api;

import com.shop.store.model.bean.ChannelListBean;
import com.shop.store.model.bean.ChannelBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *作者:SeeHeart 2019/9/23 16:21
 */
public interface BrandListApi {

    @GET("goods/category")
    Flowable<ChannelBean> getBrandTabList(@Query("id")int id);

    @GET("goods/list")
    Flowable<ChannelListBean> getBrandList(@Query("categoryId")int id, @Query("page")int page, @Query("size")int size);

}
