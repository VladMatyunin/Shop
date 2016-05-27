package ru.kpfu.repo.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyGoods;
import ru.kpfu.repo.hibernate.GoodsRepoMethods;

import java.util.List;

/**
 * Created by Vlad.M on 05.04.2016.
 */
@Repository
@Transactional
public class GoodsRepo implements GoodsRepoMethods{
    @Autowired
    SessionFactory sessionFactory;
    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addGood(MyGoods goods) {
        curSession().save(goods);
    }

    public MyGoods getGoodsById(Long id) {
        return (MyGoods) curSession().get(MyGoods.class, id);
    }

    public List<MyGoods> getGoodsByGategory(Long category_id) {
       return (List<MyGoods>)curSession().createCriteria(MyGoods.class).add(Restrictions.eq("category.id",category_id)).list();
    }

    public void deleteGoodById(Long id) {
        curSession().delete(new MyGoods(id));
    }

    public void updateGood(MyGoods good) {
        curSession().saveOrUpdate(good);
    }

    public MyGoods[] getAllGoods() {
        return (MyGoods[]) curSession().createCriteria(MyGoods.class).list().toArray();
    }
    public List<MyGoods> getGoodsRestr(int pageNum){
        return curSession().createCriteria(MyGoods.class).setFirstResult(pageNum*5) //5-number of items on 1 page
                .setMaxResults(5)
                .list();
    }

    public List<MyGoods> getGoodsRestrOrderByCategory(int pageNum) {
        return curSession().createCriteria(MyGoods.class).setFirstResult(pageNum*5) //5-number of items on 1 page
                .setMaxResults(5).addOrder(Order.asc("category"))
                .list();
    }

    public List<MyGoods> getGoodsRestrOrderByName(int pageNum) {
        return curSession().createCriteria(MyGoods.class).setFirstResult(pageNum*5) //5-number of items on 1 page
                .setMaxResults(5).addOrder(Order.asc("name"))
                .list();
    }

    public List<MyGoods> getGoodsRestrOrderByCost(int pageNum){
        return curSession().createCriteria(MyGoods.class).setFirstResult(pageNum*5) //5-number of items on 1 page
                .setMaxResults(5).addOrder(Order.asc("price"))
                .list();
    }

    public Long getMenuCount(){
        return (Long) curSession().createCriteria(MyGoods.class)
                .setProjection(Projections.rowCount())
                .list().get(0);


    }
}
