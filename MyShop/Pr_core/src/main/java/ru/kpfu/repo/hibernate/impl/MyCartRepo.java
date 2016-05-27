package ru.kpfu.repo.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyCart;
import ru.kpfu.entities.MyCartItem;
import ru.kpfu.entities.MyGoods;
import ru.kpfu.entities.MyUser;

/**
 * Created by Vlad.M on 26.04.2016.
 */
@Repository
@Transactional
public class MyCartRepo {
    @Autowired
    SessionFactory sessionFactory;
    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addNewCart(MyCart cart) {
        curSession().save(cart);
    }

    public void deleteCartByUser(MyUser user) {
       curSession().delete(new MyCart(user));
    }
    public void deleteGoodFromCart(MyUser user, MyGoods goods){
        MyCart cart = (MyCart) curSession().load(MyCart.class,getCartByUser(user).getId());
        for (int i = 0; i < cart.getItems().size(); i++){
            if (cart.getItems().get(i).getGoods().getId()==goods.getId()){
                cart.getItems().remove(i);
                curSession().update(cart);
                return;
            }
        }
        return;
    }
    public void addToCartorUpdate(MyUser user,MyGoods goods, Integer num) {
        MyCart cart = (MyCart) curSession().load(MyCart.class,getCartByUser(user).getId());
        for (int i = 0; i < cart.getItems().size(); i++){
            if (cart.getItems().get(i).getGoods().getId()==goods.getId()){
                cart.getItems().get(i).setNumber(num);
                System.out.print("WHAAAAAAAAAAAAAAAAAAAATAAAAAAAAAAAAAAAA FUUUUCK______@@@@@");
                curSession().update(cart);
                return;
            }
        }
        System.out.print("WHAAAAAAAAAAAAAAAAAAAATAAAAAAAAAAAAAAAA FUUUUCK");
        cart.getItems().add(new MyCartItem(goods,num));
        curSession().update(cart);
    }

    public MyCart getCartByUser(MyUser user) {
       return (MyCart) curSession().createCriteria(MyCart.class).add(Restrictions.eq("user",user)).uniqueResult();
       // System.out.println("___________________"+cart.getId());

    }
}
