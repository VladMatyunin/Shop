package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.MyGoods;
import ru.kpfu.repo.hibernate.GoodsRepoMethods;

import java.util.List;

/**
 * Created by Vlad.M on 05.04.2016.
 */
@Service
public class GoodsService {
    @Autowired
    GoodsRepoMethods repo;
    public void add(MyGoods goods){
        repo.addGood(goods);
        return;
    }
    public MyGoods getGoodsById(Long id) {
        return repo.getGoodsById(id);
    }

    public List<MyGoods> getGoodsByGategory(Long category_id) {
        return repo.getGoodsByGategory(category_id);
    }

    public void deleteGoodById(Long id) {
        repo.deleteGoodById(id);
    }

    public void updateGood(MyGoods good) {
        repo.updateGood(good);
    }

    public MyGoods[] getAllGoods() {
        return null;
    }
    public List<MyGoods> getGoodsRestr(int num){
        return repo.getGoodsRestr(num);
    }
    public Long getMenuCount(){
        return repo.getMenuCount();
    }
    public List<MyGoods> getGoodsByCost(int num){
        return repo.getGoodsRestrOrderByCost(num);
    }
    public List<MyGoods> getGoodsByCategory(int num){
        return repo.getGoodsRestrOrderByCategory(num);
    }
    public List<MyGoods> getGoodsByName(int num){
        return repo.getGoodsRestrOrderByName(num);
    }
}
