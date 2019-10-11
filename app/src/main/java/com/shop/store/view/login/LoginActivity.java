package com.shop.store.view.login;

import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.base.BaseActivity;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.login.LoginContract;
import com.shop.store.model.bean.LoginInfo;
import com.shop.store.persenter.login.LoginPersenter;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.txt_username)
    TextView txtUsername;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        ((LoginPersenter)persenter).login("zq1","123456");
    }

    @Override
    protected IPersenter initPersenter() {
        return new LoginPersenter();
    }

    /**
     * 登录成功返回
     * @param loginInfo
     */
    @Override
    public void loginReturn(LoginInfo loginInfo) {

    }

    /**
     * 登录失败返回
     * @param err
     */
    @Override
    public void showErrMsg(String err) {

    }
}
