package com.shop.store.interfaces.subject;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.SubjectBean;

/**
 * Created by 赵文才 on 2019/8/27 14:24.
 */

public interface SubjectContract {
    interface View extends IBaseView{
        void getSubjectReturn(SubjectBean subjectBean);
    }
    interface Persenter extends IPersenter<View>{
        void subject();
    }
}
