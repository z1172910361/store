package com.shop.store.view.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.shop.store.R;
import com.shop.store.adapter.HomeFragmentAdapter;
import com.shop.store.base.BaseFragment;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.HomeContract;
import com.shop.store.model.bean.IndexBean;
import com.shop.store.persenter.home.HomePersenter;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements HomeContract.View {


    @BindView(R.id.home_rv)
    RecyclerView homeRv;
    private HomeFragmentAdapter homeFragmentAdapter;
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        homeRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        ((HomePersenter)persenter).home();
    }

    @Override
    protected IPersenter createPersenter() {
        return new HomePersenter();
    }

    /**
     * 加载成功返回
     *
     * @param indexBean
     */
    @Override
    public void getHomeReturn(IndexBean indexBean) {
        List<IndexBean.DataBean.BannerBean> bannerList = indexBean.getData().getBanner();
        List<IndexBean.DataBean.BrandListBean> brandList = indexBean.getData().getBrandList();
        List<IndexBean.DataBean.CategoryListBean> categoryList = indexBean.getData().getCategoryList();
        List<IndexBean.DataBean.ChannelBean> channelList = indexBean.getData().getChannel();
        List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList = indexBean.getData().getHotGoodsList();
        List<IndexBean.DataBean.NewGoodsListBean> newGoodsList = indexBean.getData().getNewGoodsList();
        List<IndexBean.DataBean.TopicListBean> topicList = indexBean.getData().getTopicList();
        Log.i("See", "size: "+bannerList.size());
        Log.i("See", "size: "+brandList.size());
        Log.i("See", "size: "+categoryList.size());
        Log.i("See", "size: "+channelList.size());
        Log.i("See", "size: "+hotGoodsList.size());
        Log.i("See", "size: "+newGoodsList.size());
        Log.i("See", "size: "+topicList.size());

        homeFragmentAdapter = new HomeFragmentAdapter(bannerList,
                channelList,
                brandList,
                newGoodsList,
                hotGoodsList,
                topicList,
                categoryList,
                getContext());
        homeRv.setAdapter(homeFragmentAdapter);


    }

    /**
     * 加载失败返回
     * @param err
     */
    @Override
    public void showErrMsg(String err) {
        Log.i("See", "showErrMsg: ");
    }

}
