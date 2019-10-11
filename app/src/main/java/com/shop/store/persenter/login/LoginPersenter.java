package com.shop.store.persenter.login;

import com.shop.store.component.CommonSubscriber;
import com.shop.store.interfaces.login.LoginContract;
import com.shop.store.model.HttpManager;
import com.shop.store.model.bean.LoginInfo;
import com.shop.store.persenter.BasePersenter;
import com.shop.store.utils.RxUtils;

public class LoginPersenter extends BasePersenter<LoginContract.View> implements LoginContract.Persenter{
    /**
     * p层业务逻辑处理
     * 登录
     * @param username
     * @param pw
     */
    @Override
    public void login(String username, String pw) {
        addSubscribe(HttpManager.getTestApi().login(username,pw)
        .compose(RxUtils.<LoginInfo>rxScheduler())
        .subscribeWith(new CommonSubscriber<LoginInfo>(mView){

            @Override
            public void onNext(LoginInfo loginInfo) {
                mView.loginReturn(loginInfo);
            }
        }));
    }

}
