package com.shop.store.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shop.store.R;
import com.shop.store.model.bean.IndexBean;
import com.shop.store.view.home.home_detail_activity.BrandDetailActivity;
import com.shop.store.view.home.home_detail_activity.ChannelListActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;


import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<IndexBean.DataBean.BannerBean> dataBanner;
    private List<IndexBean.DataBean.ChannelBean> channel;
    private List<IndexBean.DataBean.BrandListBean> brandList;
    private List<IndexBean.DataBean.NewGoodsListBean> newGoodsList;
    private List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList;
    private List<IndexBean.DataBean.TopicListBean> topicList;
    private List<IndexBean.DataBean.CategoryListBean> categoryList;

    private Context context;

    public HomeFragmentAdapter(List<IndexBean.DataBean.BannerBean> dataBanner, List<IndexBean
            .DataBean.ChannelBean> channel, List<IndexBean.DataBean.BrandListBean> brandList,
                               List<IndexBean.DataBean.NewGoodsListBean> newGoodsList,
                               List<IndexBean.DataBean.HotGoodsListBean> hotGoodsList,
                               List<IndexBean.DataBean.TopicListBean> topicList, List<IndexBean
            .DataBean.CategoryListBean> categoryList, Context context) {
        this.dataBanner = dataBanner;
        this.channel = channel;
        this.brandList = brandList;
        this.newGoodsList = newGoodsList;
        this.hotGoodsList = hotGoodsList;
        this.topicList = topicList;
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        if (viewType == 1) {
            v = LayoutInflater.from(context).inflate(R.layout.layout_banner_item, parent, false);
            return new BannerHolder(v);
        }
        if (viewType == 2) {
            v = LayoutInflater.from(context).inflate(R.layout.layout_channel_item, parent, false);
            return new IndexHolder(v);
        }
        if (viewType == 3) {
            v = LayoutInflater.from(context).inflate(R.layout.fragment_brand, parent, false);
            return new BrandHolder(v);

        }
        if (viewType == 4) {
            v = LayoutInflater.from(context).inflate(R.layout.layout_homeadapter_newgoods_item, parent, false);
            return new NewGoodsHolder(v);
        }
        if (viewType == 5) {
            v = LayoutInflater.from(context).inflate(R.layout.layout_homeadapter_hotgoods_item, parent, false);
            return new HotGoodsHolder(v);
        }
        if (viewType == 6) {
            v = LayoutInflater.from(context).inflate(R.layout.layout_homeadapter_topic_item, parent, false);
            return new TopicHolder(v);
        }
        if (viewType == 7) {
            v = LayoutInflater.from(context).inflate(R.layout.layout_homeadapter_category_item, parent, false);
            return new CategoryHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        if (type == 1) {
            BannerHolder bh = (BannerHolder) holder;

            bh.banner.setImages(dataBanner).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    IndexBean.DataBean.BannerBean datas = (IndexBean.DataBean.BannerBean) path;

                    String image_url = datas.getImage_url();
                    Glide.with(context).load(image_url).into(imageView);
                }
            }).setDelayTime(3000).start();
            bh.banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {

                }
            });
        }

        if (type == 2) {
            final IndexHolder ih = (IndexHolder) holder;

            for (int i = 0; i < channel.size(); i++) {
                View view = View.inflate(context, R.layout.item_tab, null);
                ImageView item_tab_iv = view.findViewById(R.id.item_tab_iv);
                TextView item_tab_tv = view.findViewById(R.id.item_tab_tv);
                item_tab_tv.setText(channel.get(i).getName());
                ih.tab.addTab(ih.tab.newTab().setCustomView(view));
            }


            ih.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int position = tab.getPosition();
                    int id = channel.get(position).getCategoryid();
                    Intent intent = new Intent(context, ChannelListActivity.class);
                    intent.putExtra("brandId",id);
                    context.startActivity(intent);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

        }

        if (type == 3) {
            BrandHolder bh = (BrandHolder) holder;

            bh.recyc_brand.setLayoutManager(new GridLayoutManager(context, 2));
            BrandpartAdapter brandpartAdapter = new BrandpartAdapter(brandList, context);
            bh.recyc_brand.setAdapter(brandpartAdapter);

            bh.brandToolbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();

                    context.startActivity(intent);
                }
            });

            brandpartAdapter.setBrandOnClick(new BrandpartAdapter.BrandOnClick() {
                @Override
                public void brandOnItemClick(int position) {
                    Intent intent = new Intent(context,BrandDetailActivity.class);
                    intent.putExtra("id",brandList.get(position).getId());
                    context.startActivity(intent);
                }
            });
        }

        if (type == 4) {
            NewGoodsHolder nh = (NewGoodsHolder) holder;
            nh.recyc_newGoods.setLayoutManager(new GridLayoutManager(context, 2));
            NewGoodsAdapter newGoodsAdapter = new NewGoodsAdapter(newGoodsList, context);
            nh.recyc_newGoods.setAdapter(newGoodsAdapter);
        }

        if (type == 5) {
            HotGoodsHolder hh = (HotGoodsHolder) holder;
            hh.recyc_hotGoods.setLayoutManager(new LinearLayoutManager(context));
            HotGoodsAdapter hotGoodsAdapter = new HotGoodsAdapter(hotGoodsList, context);
            hh.recyc_hotGoods.setAdapter(hotGoodsAdapter);
        }

        if (type == 6) {
            TopicHolder th = (TopicHolder) holder;
            th.recyc_topic.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

            TopicAdapter topicAdapter = new TopicAdapter(topicList, context);
            th.recyc_topic.setAdapter(topicAdapter);
        }

        if (type == 7) {
            CategoryHolder ch = (CategoryHolder) holder;
            ch.tv.setText(categoryList.get(position - 6).getName());
            List<IndexBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryList.get(position - 6).getGoodsList();

            GridLayoutManager layout = new GridLayoutManager(context, 2);
            ch.recyc_category.setLayoutManager(layout);
            CategoryAdapter categoryAdapter = new CategoryAdapter(goodsList, context);
            ch.recyc_category.setAdapter(categoryAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 6 + categoryList.size();
    }

    class BannerHolder extends RecyclerView.ViewHolder {
        Banner banner;
        Button searchBtn;
        public BannerHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.home_banner);
            searchBtn = itemView.findViewById(R.id.search_btn);
        }
    }

    class IndexHolder extends RecyclerView.ViewHolder {
        TabLayout tab;
        public IndexHolder(View itemView) {
            super(itemView);
            tab = itemView.findViewById(R.id.tab);
        }
    }

    class BrandHolder extends RecyclerView.ViewHolder {
        RecyclerView recyc_brand;
        TextView brandToolbar;
        public BrandHolder(View itemView) {
            super(itemView);
            brandToolbar = itemView.findViewById(R.id.brand_toolbar);
            recyc_brand = itemView.findViewById(R.id.recyc_brand);
        }
    }

    class NewGoodsHolder extends RecyclerView.ViewHolder {
        RecyclerView recyc_newGoods;

        public NewGoodsHolder(View itemView) {
            super(itemView);
            recyc_newGoods = itemView.findViewById(R.id.recyc_newgoods);
        }
    }

    class HotGoodsHolder extends RecyclerView.ViewHolder {
        RecyclerView recyc_hotGoods;

        public HotGoodsHolder(View itemView) {
            super(itemView);
            recyc_hotGoods = itemView.findViewById(R.id.recyc_topgoods);
        }
    }

    class TopicHolder extends RecyclerView.ViewHolder {
        RecyclerView recyc_topic;

        public TopicHolder(View itemView) {
            super(itemView);
            recyc_topic = itemView.findViewById(R.id.recyc_topic);
        }
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        TextView tv;
        RecyclerView recyc_category;

        public CategoryHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_homeadapter_category_item);
            recyc_category = itemView.findViewById(R.id.recyc_category);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {

            return 2;
        } else if (position == 2) {

            return 3;
        } else if (position == 3) {

            return 4;
        } else if (position == 4) {

            return 5;
        } else if (position == 5) {

            return 6;
        }
        return 7;
    }

}
