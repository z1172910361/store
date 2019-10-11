package com.shop.store.model.bean;

import java.util.List;

/*
 *作者:SeeHeart 2019/10/9 10:37
 */
public class AddressBean {
    /**
     * errno : 0
     * errmsg :
     * data : [{"id":8,"name":"张三","user_id":"32","area":"\b昌平区","province":"北京","city":"北京","address":"昌平","mobile":"13311111111","is_default":0}]
     */

    private int errno;
    private String errmsg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 8
         * name : 张三
         * user_id : 32
         * area : 昌平区
         * province : 北京
         * city : 北京
         * address : 昌平
         * mobile : 13311111111
         * is_default : 0
         */

        private int id;
        private String name;
        private String user_id;
        private String area;
        private String province;
        private String city;
        private String address;
        private String mobile;
        private int is_default;

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

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }
    }
}
