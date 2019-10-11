package com.shop.store.model.bean;

import java.util.List;

/*
 *作者:SeeHeart 2019/9/28 11:59
 */
public class ShopDetailElseBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"goodsList":[{"id":1006007,"name":"秋冬保暖加厚澳洲羊毛被","list_pic_url":"http://yanxuan.nosdn.127.net/66425d1ed50b3968fed27c822fdd32e0.png","retail_price":459},{"id":1006010,"name":"秋冬保暖加厚细羊毛被","list_pic_url":"http://yanxuan.nosdn.127.net/8fe022126a2789d970f82853be13a5e6.png","retail_price":659},{"id":1006014,"name":"双宫茧桑蚕丝被 子母被","list_pic_url":"http://yanxuan.nosdn.127.net/2b537159f0f789034bf8c4b339c43750.png","retail_price":1399},{"id":1009009,"name":"白鹅绒秋冬加厚羽绒被","list_pic_url":"http://yanxuan.nosdn.127.net/9791006f25e26b2d7c81f41f87ce8619.png","retail_price":1999},{"id":1009012,"name":"可水洗舒柔丝羽绒枕","list_pic_url":"http://yanxuan.nosdn.127.net/a196b367f23ccfd8205b6da647c62b84.png","retail_price":59},{"id":1009013,"name":"可水洗抗菌防螨丝羽绒枕","list_pic_url":"http://yanxuan.nosdn.127.net/da56fda947d0f430d5f4cf4aba14e679.png","retail_price":99},{"id":1019000,"name":"升级款护颈波浪记忆枕","list_pic_url":"http://yanxuan.nosdn.127.net/77c09feb378814be712741b273d16656.png","retail_price":99},{"id":1019001,"name":"升级款护颈加翼记忆枕","list_pic_url":"http://yanxuan.nosdn.127.net/7644803ab19b3e398456aa5a54229363.png","retail_price":109}]}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<GoodsListBean> goodsList;

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            /**
             * id : 1006007
             * name : 秋冬保暖加厚澳洲羊毛被
             * list_pic_url : http://yanxuan.nosdn.127.net/66425d1ed50b3968fed27c822fdd32e0.png
             * retail_price : 459
             */

            private int id;
            private String name;
            private String list_pic_url;
            private int retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public int getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(int retail_price) {
                this.retail_price = retail_price;
            }
        }
    }
}
