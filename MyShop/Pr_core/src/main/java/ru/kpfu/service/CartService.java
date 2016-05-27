package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.entities.MyCart;
import ru.kpfu.entities.MyGoods;
import ru.kpfu.entities.MyUser;
import ru.kpfu.repo.hibernate.impl.MyCartRepo;

/**
 * Created by Vlad.M on 27.04.2016.
 */
@Service
public class CartService {
   @Autowired
    MyCartRepo repo;
    @Transactional
    public void addNewCart(MyCart cart) {
        repo.addNewCart(cart);
    }

    public void deleteCartByUser(MyUser user) {
        repo.deleteCartByUser(user);
    }

    public void addToCart(MyUser user,MyGoods goods, Integer num) {
        repo.addToCartorUpdate(user,goods, num);
    }
    public void deleteGoodFromCart(MyUser user, MyGoods goods){
      repo.deleteGoodFromCart(user,goods);
    }
    public void addToCartorUpdate(MyUser user,MyGoods goods, Integer num) {
       repo.addToCartorUpdate(user,goods,num);
    }

    public MyCart getCartByUser(MyUser user) {
        return repo.getCartByUser(user);
    }
}
