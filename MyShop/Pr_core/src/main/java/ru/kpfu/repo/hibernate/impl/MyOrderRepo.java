package ru.kpfu.repo.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyOrder;
import ru.kpfu.entities.MyUser;

import javax.persistence.criteria.Order;
import java.util.List;

/**
 * Created by Vlad.M on 26.04.2016.
 */
@Transactional
@Repository
public class MyOrderRepo {
    @Autowired
    SessionFactory sessionFactory;
    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }
    public void createOrder(MyOrder order){
        curSession().merge(order);
    }
    public List<MyOrder> getOrders(MyUser user){
        return (List<MyOrder>) curSession().createCriteria(MyOrder.class).add(Restrictions.eq("user",user)).list();
    }
    public void deleteOrder(Order order){
        curSession().delete(order);
    }
}
