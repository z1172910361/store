package com.shop.store.model.api;


import com.shop.store.model.bean.LoginInfo;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface TestApi {

    //String test_url = "https://mall.tsingglobal.cn/";
    String test_url = "http://yun918.cn/study/public/index.php/";

    @POST("web/service/user/loginUser")
    @Multipart
    Flowable<LoginInfo> login(@Part("email") RequestBody email, @Part("passWord") RequestBody pw);

    @POST("login")
    @FormUrlEncoded
    Flowable<LoginInfo> login(@Field("username") String username, @Field("password") String pw);


}
