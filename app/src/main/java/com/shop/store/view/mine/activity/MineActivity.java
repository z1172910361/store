package com.shop.store.view.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.store.R;
import com.shop.store.adapter.MineAddressAdapter;
import com.shop.store.base.BaseActivity;
import com.shop.store.constants.Constant;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.mine.address.MineAddressContract;
import com.shop.store.model.bean.AddressBean;
import com.shop.store.persenter.mine.address.MineAddressPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 *作者:SeeHeart 2019/10/8 16:50
 */
public class MineActivity extends BaseActivity implements MineAddressContract.View, MineAddressAdapter.MineAddressOnClick {
    @BindView(R.id.mine_address_finish)
    TextView mineAddressFinish;
    @BindView(R.id.mine_address_rv)
    RecyclerView mineAddressRv;
    @BindView(R.id.mine_address_new_tv)
    TextView mineAddressNewTv;
    private List<AddressBean.DataBean> addressList = new ArrayList<>();
    private MineAddressAdapter mineAddressAdapter = new MineAddressAdapter(addressList, this);

    @Override
    protected int getLayout() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initView() {
        mineAddressRv.setLayoutManager(new LinearLayoutManager(this));

        mineAddressRv.setAdapter(mineAddressAdapter);
        mineAddressAdapter.setMineAddressOnClick(this);
    }

    @Override
    protected void initData() {
        ((MineAddressPresenter)persenter).getMineAddress(Constant.UID);
    }

    @Override
    protected IPersenter initPersenter() {
        return new MineAddressPresenter();
    }

    @OnClick({R.id.mine_address_finish, R.id.mine_address_new_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mine_address_finish:
                finish();
                break;
            case R.id.mine_address_new_tv:
                Intent intent = new Intent(this, AddressActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void getMineAddressReturn(AddressBean addressBean) {
        List<AddressBean.DataBean> data = addressBean.getData();
        if (data!=null && !data.isEmpty()){
            addressList.clear();
            addressList.addAll(data);
            mineAddressAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getMineAddressClickReturn(AddressBean addressBean) {
        Log.i("See", "deleteAddress");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MineAddressPresenter)persenter).getMineAddress(Constant.UID);
    }

    @Override
    public void mineAddressOnItemClick(int position) {
        AddressBean.DataBean dataBean = addressList.get(position);
        final int id = dataBean.getId();
        new AlertDialog.Builder(this).setTitle("确定删除此地址？")
                .setNegativeButton("取消",null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MineAddressPresenter)persenter).getMineAddressClick(Constant.UID,id);
                        mineAddressAdapter.notifyDataSetChanged();
                        Toast.makeText(MineActivity.this, "删除完成", Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }
}
