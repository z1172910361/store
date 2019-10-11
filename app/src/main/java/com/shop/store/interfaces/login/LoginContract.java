package com.shop.store.interfaces.login;


import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.model.bean.LoginInfo;

public interface LoginContract {

    //登录返回的接口定义
    interface View extends IBaseView {
        void loginReturn(LoginInfo msg);
    }

    //登录的p层接口
    interface Persenter extends IPersenter<View> {
        void login(String username, String pw);
    }


}
