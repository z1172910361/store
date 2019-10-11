package com.shop.store.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shop.store.interfaces.IBaseView;
import com.shop.store.interfaces.IPersenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends IBaseView,P extends IPersenter> extends Fragment implements IBaseView {

    protected Context context;
    protected P persenter;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),null);
        context = this.getContext();
        unbinder = ButterKnife.bind(this,view);
        initView(view);
        persenter = createPersenter();
        if (persenter!=null) persenter.attchView(this);
        initData();
        return view;
    }

    //获取布局
    protected abstract int getLayout();

    //初始化布局
    protected abstract void initView(View view);

    //初始化数据
    protected abstract void initData();

    //创建P
    protected abstract P createPersenter();

    @Override
    public void onResume() {
        super.onResume();
        if(persenter != null){              //11111111
            persenter.attchView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }
}
