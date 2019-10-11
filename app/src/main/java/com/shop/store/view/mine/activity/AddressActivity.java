package com.shop.store.view.mine.activity;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.shop.store.R;
import com.shop.store.base.BaseActivity;
import com.shop.store.constants.Constant;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.mine.address.AddressContract;
import com.shop.store.model.bean.AddressBean;
import com.shop.store.persenter.mine.address.AddressPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/*
 *作者:SeeHeart 2019/10/8 17:15
 */
public class AddressActivity extends BaseActivity implements AddressContract.View {
    @BindView(R.id.address_finish)
    TextView addressFinish;
    @BindView(R.id.address_name_et)
    EditText addressNameEt;
    @BindView(R.id.address_phone_et)
    EditText addressPhoneEt;
    @BindView(R.id.address_address_et)
    TextView addressAddressEt;
    @BindView(R.id.address_detail_et)
    EditText addressDetailEt;
    @BindView(R.id.address_default_cb)
    CheckBox addressDefaultCb;
    @BindView(R.id.address_cancel_tv)
    TextView addressCancelTv;
    @BindView(R.id.address_save_tv)
    TextView addressSaveTv;

    private CityPickerView mPicker = new CityPickerView();

    private String provinceAddress = null;
    private String cityAddress = null;
    private String areaAddress = null;
    private int isDefault;

    @Override
    protected int getLayout() {
        return R.layout.activity_address;
    }

    @Override
    protected void initView() {
        mPicker.init(this); //必须！  初始化城市数据
        addressDefaultCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    isDefault = Constant.DEFAULT_ADDRESS_TRUE;
                    Toast.makeText(AddressActivity.this, "设置为默认地址", Toast.LENGTH_SHORT).show();
                }else {
                    isDefault = Constant.DEFAULT_ADDRESS_FALSE;
                    Toast.makeText(AddressActivity.this, "未设置默认地址", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter initPersenter() {
        return new AddressPresenter();
    }

    @OnClick({R.id.address_finish, R.id.address_address_et, R.id.address_cancel_tv, R.id.address_save_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.address_finish:
                finish();
                break;
            case R.id.address_address_et:
                addressLinkage(view);
                break;
            case R.id.address_cancel_tv:
                finish();
                break;
            case R.id.address_save_tv:
                String addressName = addressNameEt.getText().toString();
                String addressPhone = addressPhoneEt.getText().toString();
                String addressAddress = addressAddressEt.getText().toString();
                String addressDetail = addressDetailEt.getText().toString();
                if (TextUtils.isEmpty(addressName)) {
                    Toast.makeText(this, "请填写姓名", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.isEmpty(addressPhone)) {
                        Toast.makeText(this, "请填写手机号", Toast.LENGTH_SHORT).show();
                    } else {
                        if (TextUtils.isEmpty(addressAddress)) {
                            Toast.makeText(this, "请选择地址", Toast.LENGTH_SHORT).show();
                        } else {
                            if (TextUtils.isEmpty(addressDetail)) {
                                Toast.makeText(this, "请填写详细地址", Toast.LENGTH_SHORT).show();
                            } else {
                                if (provinceAddress != null && cityAddress != null && areaAddress != null) {
                                    ((AddressPresenter) persenter).getAddressInfo(Constant.ADDRESSID, Constant.UID, addressName
                                            , addressPhone, provinceAddress, cityAddress,
                                            areaAddress, addressDetail, isDefault);
                                    Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                                    AddressActivity.this.finish();
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    private void addressLinkage(View view) {
        if (view == addressAddressEt) {  //地区联动选择
            //添加默认的配置，可以自己修改
            CityConfig cityConfig = new CityConfig.Builder()
                    .province("北京") //设置默认显示省份
                    .build();
            mPicker.setConfig(cityConfig);
            //监听选择点击事件及返回结果
            mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                    //省份
                    if (province != null && city != null && district != null) {
                        String provinceOption = province.toString();
                        String cityOption = city.toString();
                        String districtOption = district.toString();
                        addressAddressEt.setText(provinceOption + "  " + cityOption + "  " + districtOption);
                        provinceAddress = provinceOption;
                        cityAddress = cityOption;
                        areaAddress = districtOption;
                    }
                }

                @Override
                public void onCancel() {
                    ToastUtils.showLongToast(AddressActivity.this, "已取消");
                }
            });
            //显示
            mPicker.showCityPicker();
        }
    }

    @Override
    public void getAddressInfoReturn(AddressBean addressBean) {
        Log.i("See", "getAddressInfoReturn: ");
    }
}
