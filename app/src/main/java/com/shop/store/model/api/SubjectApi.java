package com.shop.store.model.api;

import com.shop.store.model.bean.SubjectBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by 赵文才 on 2019/8/27 14:17.
 */

public interface SubjectApi {

    @GET("topic/list")
    Flowable<SubjectBean> getSubjectData();
}
