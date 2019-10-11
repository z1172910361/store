package com.shop.store.view.home.home_detail_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.adapter.ShopDetailElseAdapter;
import com.shop.store.adapter.ShopDetailParamsAdapter;
import com.shop.store.adapter.ShopDetailQuestionAdapter;
import com.shop.store.adapter.WindowSpecificationAdapter;
import com.shop.store.base.BaseActivity;
import com.shop.store.constants.Constant;
import com.shop.store.interfaces.IPersenter;
import com.shop.store.interfaces.home.home_detail.ShopDetailContract;
import com.shop.store.model.bean.ShopDetailBean;
import com.shop.store.model.bean.ShopDetailElseBean;
import com.shop.store.persenter.home.home_detail.ShopDetailPresenter;
import com.shop.store.utils.HtmlUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 *作者:SeeHeart 2019/9/27 15:49
 */
public class ShopDetailActivity extends BaseActivity implements ShopDetailContract.View, View.OnClickListener {
    @BindView(R.id.shop_detail_finish)
    TextView shopDetailFinish;
    @BindView(R.id.shop_detail_banner)
    Banner shopDetailBanner;
    @BindView(R.id.shop_detail_nameTv)
    TextView shopDetailNameTv;
    @BindView(R.id.shop_detail_titleTv)
    TextView shopDetailTitleTv;
    @BindView(R.id.shop_detail_priceTv)
    TextView shopDetailPriceTv;
    //选择规格
    @BindView(R.id.specification_rl)
    RelativeLayout specificationRl;
    //评价
    @BindView(R.id.appraise_rv)
    RecyclerView appraiseRv;
    //商品参数
    @BindView(R.id.params_rv)
    RecyclerView paramsRv;

    @BindView(R.id.shop_detail_web)
    WebView shopDetailWeb;

    //常见问题
    @BindView(R.id.question_rv)
    RecyclerView questionRv;
    //大家都在看
    @BindView(R.id.else_rv)
    RecyclerView elseRv;
    @BindView(R.id.seekbar_iv)
    ImageView seekbarIv;
    @BindView(R.id.cart_iv)
    ImageView cartIv;
    @BindView(R.id.buy_now_btn)
    TextView buyNowBtn;
    @BindView(R.id.addcart_tv)
    TextView addcartTv;
    @BindView(R.id.rl)
    RelativeLayout rl;

    private int id;
    private static int WINDOW_COUNT = 1;

    private List<ShopDetailBean.DataBeanX.AttributeBean> paramsList;
    private List<ShopDetailBean.DataBeanX.IssueBean> questionList;
    private ShopDetailParamsAdapter shopDetailParamsAdapter;
    private ShopDetailQuestionAdapter shopDetailQuestionAdapter;
    private List<ShopDetailElseBean.DataBean.GoodsListBean> elseList;
    private ShopDetailElseAdapter shopDetailElseAdapter;
    private PopupWindow popupWindow;
    private List<ShopDetailBean.DataBeanX.SpecificationListBean> specificationList;
    private TextView window_countTv;
    private WindowSpecificationAdapter windowSpecificationAdapter;
    private String img_url;
    private int retail_price;
    private ImageView window_shop_iv;
    private TextView window_shop_price;
    private ShopDetailBean.DataBeanX data;

    @Override
    protected int getLayout() {
        return R.layout.activity_shopdetail;
    }

    @Override
    protected void initView() {
        initPopupWindow();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        //评价
        appraiseRv.setLayoutManager(new LinearLayoutManager(this));

        //商品参数
        paramsRv.setLayoutManager(new LinearLayoutManager(this));
        paramsList = new ArrayList<>();
        shopDetailParamsAdapter = new ShopDetailParamsAdapter(paramsList, this);
        paramsRv.setAdapter(shopDetailParamsAdapter);

        //常见问题
        questionRv.setLayoutManager(new LinearLayoutManager(this));
        questionList = new ArrayList<>();
        shopDetailQuestionAdapter = new ShopDetailQuestionAdapter(questionList, this);
        questionRv.setAdapter(shopDetailQuestionAdapter);

        //大家都在看
        elseRv.setLayoutManager(new GridLayoutManager(this, 2));
        elseList = new ArrayList<>();
        shopDetailElseAdapter = new ShopDetailElseAdapter(elseList, this);
        elseRv.setAdapter(shopDetailElseAdapter);

    }

    @Override
    protected void initData() {

        ((ShopDetailPresenter) persenter).getShopDetailList(id);
        ((ShopDetailPresenter) persenter).getShopDetailElseList(id);

    }

    @Override
    protected IPersenter initPersenter() {
        return new ShopDetailPresenter();
    }

    @Override
    public void getShopDetailReturn(ShopDetailBean shopDetailBean) {
        data = shopDetailBean.getData();
        List<ShopDetailBean.DataBeanX.GalleryBean> gallery = data.getGallery();
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < gallery.size(); i++) {
            imgs.add(gallery.get(i).getImg_url());
        }


        img_url = gallery.get(0).getImg_url();
        retail_price = data.getInfo().getRetail_price();
        if (img_url != null) Glide.with(this).load(img_url).into(window_shop_iv);
        if (retail_price != 0) window_shop_price.setText("价格：￥"+retail_price);

        shopDetailNameTv.setText(data.getInfo().getName());
        shopDetailTitleTv.setText(data.getInfo().getGoods_brief());
        shopDetailPriceTv.setText("￥" + retail_price);
        shopDetailBanner.setImages(imgs).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String) path).into(imageView);
            }
        }).start();

        //商品参数数据
        List<ShopDetailBean.DataBeanX.AttributeBean> beanParamsList = data.getAttribute();
        paramsList.addAll(beanParamsList);
        shopDetailParamsAdapter.notifyDataSetChanged();

        //常见问题
        List<ShopDetailBean.DataBeanX.IssueBean> beanQuestionList = data.getIssue();
        if (beanQuestionList != null && !beanQuestionList.isEmpty()) {
            questionList.addAll(beanQuestionList);
            shopDetailQuestionAdapter.notifyDataSetChanged();
        }

        //弹窗规格
        List<ShopDetailBean.DataBeanX.SpecificationListBean> specificationBeanList = data.getSpecificationList();
        if (specificationBeanList != null && !specificationBeanList.isEmpty()) {
            specificationList.addAll(specificationBeanList);
            windowSpecificationAdapter.notifyDataSetChanged();
        }

        setWebData(data);

    }

    @Override
    public void getShopDetailElseReturn(ShopDetailElseBean shopDetailElseBean) {

        //大家都在看
        List<ShopDetailElseBean.DataBean.GoodsListBean> goodsList = shopDetailElseBean.getData().getGoodsList();

        elseList.addAll(goodsList);
        shopDetailElseAdapter.notifyDataSetChanged();

    }

    @Override
    public void getAddCartShopReturn(ShopDetailBean shopDetailBean) {
        Log.i("See", "getAddCartShopReturn: "+shopDetailBean);
    }

    private void setWebData(ShopDetailBean.DataBeanX data) {

        WebSettings settings = shopDetailWeb.getSettings();
        // 设置WebView支持JavaScript
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        settings.setBlockNetworkImage(true);// 把图片加载放在最后来加载渲染
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //设置不让其跳转浏览器
        shopDetailWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        // 添加客户端支持
        shopDetailWeb.setWebChromeClient(new WebChromeClient());
//        mWebView.loadUrl(TEXTURL);

        //不加这个图片显示不出来
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            shopDetailWeb.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        shopDetailWeb.getSettings().setBlockNetworkImage(false);

        //允许cookie 不然有的网站无法登陆
        CookieManager mCookieManager = CookieManager.getInstance();
        mCookieManager.setAcceptCookie(true);
        mCookieManager.setAcceptThirdPartyCookies(shopDetailWeb, true);

        shopDetailWeb.loadData(data.getInfo().getGoods_desc(), HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);

    }

    @OnClick({R.id.shop_detail_finish, R.id.specification_rl, R.id.seekbar_iv, R.id.cart_iv, R.id.buy_now_btn, R.id.addcart_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shop_detail_finish:
                finish();
                break;
            case R.id.specification_rl:
                popupWindow.showAtLocation(rl, Gravity.CENTER, 0, 0);
                break;
            case R.id.seekbar_iv:
                break;
            case R.id.cart_iv:
                break;
            case R.id.buy_now_btn:
                break;
            case R.id.addcart_tv:
                popupWindow.showAtLocation(rl, Gravity.CENTER, 0, 0);
                break;

        }
    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.window_shop_layout, null);

        initWindowView(view);

        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

    }

    private void initWindowView(View view) {
        RecyclerView window_shop_rv = view.findViewById(R.id.window_shop_rv);
        window_shop_iv = view.findViewById(R.id.window_shop_iv);
        window_shop_price = view.findViewById(R.id.window_shop_price);
        TextView window_shop_specification = view.findViewById(R.id.window_shop_specification);
        TextView window_finish = view.findViewById(R.id.window_finish);
        TextView window_count_subtract = view.findViewById(R.id.window_count_subtract);
        window_countTv = view.findViewById(R.id.window_countTv);
        TextView window_count_add = view.findViewById(R.id.window_count_add);
        ImageView window_seekbar_iv = view.findViewById(R.id.window_seekbar_iv);
        ImageView window_cart_iv = view.findViewById(R.id.window_cart_iv);
        TextView window_buyNow_btn = view.findViewById(R.id.window_buyNow_btn);
        TextView window_addCart_tv = view.findViewById(R.id.window_addCart_tv);

        window_shop_rv.setLayoutManager(new LinearLayoutManager(this));
        specificationList = new ArrayList<>();
        windowSpecificationAdapter = new WindowSpecificationAdapter(specificationList, this);
        window_shop_rv.setAdapter(windowSpecificationAdapter);

        window_countTv.setText(WINDOW_COUNT + "");
        window_finish.setOnClickListener(this);
        window_count_subtract.setOnClickListener(this);
        window_count_add.setOnClickListener(this);
        window_seekbar_iv.setOnClickListener(this);
        window_cart_iv.setOnClickListener(this);
        window_buyNow_btn.setOnClickListener(this);
        window_addCart_tv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.window_finish:
                popupWindow.dismiss();
                break;
            case R.id.window_count_subtract:
                if (WINDOW_COUNT > 1) {
                    WINDOW_COUNT--;
                }
                break;
            case R.id.window_count_add:
                WINDOW_COUNT++;
                break;
            case R.id.window_seekbar_iv:
                Toast.makeText(this, "星标", Toast.LENGTH_SHORT).show();
                break;
            case R.id.window_cart_iv:
                break;
            case R.id.window_buyNow_btn:
                Toast.makeText(this, "立即购买", Toast.LENGTH_SHORT).show();
                break;
            case R.id.window_addCart_tv:
                if (data!=null) {
                    int productListId = data.getProductList().get(0).getId();
                    ((ShopDetailPresenter) persenter).getAddCartShop(Constant.UID,data.getInfo().getId(),productListId,WINDOW_COUNT);
                    Toast.makeText(this, "添加购物车成功，前往购物车查看", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        window_countTv.setText(WINDOW_COUNT + "");
    }
}
