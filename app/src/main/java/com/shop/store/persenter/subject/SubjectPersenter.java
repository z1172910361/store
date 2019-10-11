package com.shop.store.persenter.subject;

import com.shop.store.base.BaseFragment;
import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.subject.SubjectContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.SubjectBean;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

/**
 * Created by 赵文才 on 2019/8/27 14:25.
 */

public class SubjectPersenter extends BasePersenter<SubjectContract.View> implements SubjectContract.Persenter {
    @Override
    public void subject() {
        addSubscribe(HttpManager.getSubjectApi().getSubjectData()
                    .compose(RxUtils.<SubjectBean>rxScheduler())
                    .subscribeWith(new CommonSubscriber<SubjectBean>(mView) {
                        @Override
                        public void onNext(SubjectBean subjectBean) {
                            mView.getSubjectReturn(subjectBean);
                        }
                    }));
    }
}
