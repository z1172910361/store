package com.shop.store.utils;

import com.shop.store.apps.MyApp;
import com.shop.store.dao.CollectVoDao;
import com.shop.store.dao.DaoSession;
import com.shop.store.db.CollectVo;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class DBUtils {

    /**
     * 插入数据
     * @param collectVo
     */
    public static void insertCollectVo(CollectVo collectVo){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Title.eq(collectVo.title)).list();
        if(list == null || list.size() == 0){
            daoSession.getCollectVoDao().insert(collectVo);
        }
    }

    /**
     * 插入集合
     * @param list
     */
    public static void insertList(List<CollectVo> list){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        daoSession.getCollectVoDao().insertInTx(list);
    }

    /**
     * 查找数据
     * @param collectVo
     * @return
     */
    public static List<CollectVo> queryCollectByVo(CollectVo collectVo){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Id.eq(collectVo.getId())).list();
        return list;
    }

    /**
     * 删除数据
     * @param collectVo
     */
    public static void deleteByCollect(CollectVo collectVo){
        DaoSession daoSession = MyApp.myApp.getDaoSession();
        QueryBuilder builder = daoSession.getCollectVoDao().queryBuilder();
        List<CollectVo> list = builder.where(CollectVoDao.Properties.Id.eq(collectVo.getId())).list();
        if(list != null && list.size() > 0){
            daoSession.getCollectVoDao().delete(collectVo);
        }
    }

}
