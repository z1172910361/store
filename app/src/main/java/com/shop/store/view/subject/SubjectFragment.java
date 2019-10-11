package com.shop.store.view.subject;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shop.store.R;
import com.shop.store.adapter.SubjectFragmentAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.subject.SubjectContract;
import com.shop.store.model.bean.SubjectBean;
import com.shop.store.persenter.subject.SubjectPersenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SubjectFragment extends BaseFragment implements SubjectContract.View {


    @BindView(R.id.subject_rv)
    RecyclerView subjectRv;

    @Override
    public void showErrMsg(String err) {
        Log.i("See", "showErrMsg: "+err);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_subject;
    }

    @Override
    protected void initView(View view) {
        subjectRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        ((SubjectPersenter)persenter).subject();
    }

    @Override
    protected IPersenter createPersenter() {
        return new SubjectPersenter();
    }

    @Override
    public void getSubjectReturn(SubjectBean subjectBean) {
        List<SubjectBean.DataBeanX.DataBean> data = subjectBean.getData().getData();
        Log.i("See", "getSubjectReturn: "+data.size());
        SubjectFragmentAdapter subjectFragmentAdapter = new SubjectFragmentAdapter(data, getActivity());
        subjectRv.setAdapter(subjectFragmentAdapter);
    }
}
