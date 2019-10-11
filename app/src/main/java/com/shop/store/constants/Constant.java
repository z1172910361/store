package com.shop.store.constants;

import com.shop.store.apps.MyApp;

import java.io.File;

public class Constant {

    public static final String Base_Url = "https://cdwan.cn/";

    public static final String Base_Group_Url = "https://cdwan.cn/api/";

    public static final String Base_apk_url = "http://yun918.cn/study/public/";




    //网络缓存的地址
    public static final String PATH_DATA = MyApp.myApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/ShiXun";

    public static final int CLICK_TIME = 2000;

    public static String UID = "zzz";

    public static String ADDRESSID = "";
    public static int DEFAULT_ADDRESS_TRUE = 1;
    public static int DEFAULT_ADDRESS_FALSE = 0;
}
