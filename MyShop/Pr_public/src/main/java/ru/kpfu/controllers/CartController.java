package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.aspect.MailingAsp;
import ru.kpfu.entities.MyCart;
import ru.kpfu.entities.MyCartItem;
import ru.kpfu.entities.MyOrder;
import ru.kpfu.entities.MyUser;
import ru.kpfu.repo.hibernate.impl.MyOrderRepo;
import ru.kpfu.service.CartService;
import ru.kpfu.service.GoodsService;
import ru.kpfu.service.UserService;

import java.util.ArrayList;

/**
 * Created by Vlad.M on 25.04.2016.
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;
    @Autowired
    MyOrderRepo orderRepo;
    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String addToCart(@PathVariable Long id, ModelMap map) {
        MyUser user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
         if (cartService.getCartByUser(user) == null){
             MyCart cart = new MyCart();
             cart.setUser(user);
             ArrayList<MyCartItem> cartItems = new ArrayList<MyCartItem>();
             cartItems.add(new MyCartItem(goodsService.getGoodsById(id),1));
             cart.setItems(cartItems);
             cartService.addNewCart(cart);
         }
        else{
          cartService.addToCartorUpdate(user,goodsService.getGoodsById(id),1);
         }
    return "ok";
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String loadCart(ModelMap map) {
        MyUser user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        map.addAttribute("cart",cartService.getCartByUser(user));
        return "Cart";
    }
    @RequestMapping(value = "/changeNumber", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void changeNumberProduct(@RequestParam("id") Long id, @RequestParam("number") Integer number) {
        MyUser user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("_____________"+goodsService.getGoodsById(id).getId());
        cartService.addToCartorUpdate(user,goodsService.getGoodsById(id),number);
    }
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@RequestParam Long id) {
        MyUser user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        cartService.deleteGoodFromCart(user,goodsService.getGoodsById(id));
    }
    @RequestMapping(value = "/neworder")
    @ResponseStatus(value = HttpStatus.OK)
    @MailingAsp
    public void doOrder() {
        System.out.println("______________I AM IN NEW ORDER");
        MyUser user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        MyOrder order = new MyOrder(user,cartService.getCartByUser(user));
        orderRepo.createOrder(order);
    }
}
