package ru.kpfu.repo.hibernate;

import ru.kpfu.entities.MyGoods;

import java.util.List;

/**
 * Created by Vlad.M on 05.04.2016.
 */
public interface GoodsRepoMethods {
    void addGood(MyGoods goods);
    MyGoods getGoodsById(Long id);
    List<MyGoods> getGoodsByGategory(Long category_id);
    void deleteGoodById(Long id);
    void updateGood(MyGoods good);
    MyGoods[] getAllGoods();
    List<MyGoods> getGoodsRestr(int o);
    List<MyGoods> getGoodsRestrOrderByCost(int o);
    List<MyGoods> getGoodsRestrOrderByCategory(int o);
    List<MyGoods> getGoodsRestrOrderByName(int o);
    Long getMenuCount();
}
