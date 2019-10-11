package com.shop.store.apps;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.shop.store.dao.DaoMaster;
import com.shop.store.dao.DaoSession;
import com.shop.store.utils.MyDaoMaster;


public class MyApp extends Application {

    private static String DB_NAME = "1901B";


    public static MyApp myApp;

    private SQLiteDatabase sqLiteDatabase;
    private MyDaoMaster myDaoMaster;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        initDB();
    }

    private void initDB(){
        myDaoMaster = new MyDaoMaster(this,DB_NAME);
        sqLiteDatabase = myDaoMaster.getWritableDatabase();
        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
