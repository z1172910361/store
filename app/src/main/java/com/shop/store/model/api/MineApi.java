package com.shop.store.model.api;

import com.shop.store.model.bean.AddressBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *作者:SeeHeart 2019/10/9 10:56
 */
public interface MineApi {

    @GET("address/listNew")
    Flowable<AddressBean> getMineAddress(@Query("uid")String uid);

    /**
     *
     * @param id    收货地址id
     * @param uid   uid
     * @param mobile    手机号
     * @param province  省份
     * @param city  城市
     * @param area  区县
     * @param address   详细地址
     * @param isDefault 是否默认
     * @return
     */
    @POST("address/saveNew")
    @FormUrlEncoded
    Flowable<AddressBean> getAddressInfo(@Field("id")String id,
                                         @Field("uid")String uid,
                                         @Field("name")String name,
                                         @Field("mobile")String mobile,
                                         @Field("province")String province,
                                         @Field("city")String city,
                                         @Field("area")String area,
                                         @Field("address")String address,
                                         @Field("is_default")int isDefault);

    @POST("address/delete")
    @FormUrlEncoded
    Flowable<AddressBean> getMineAddressClick(@Field("uid")String uid,@Field("id")int id);
}
