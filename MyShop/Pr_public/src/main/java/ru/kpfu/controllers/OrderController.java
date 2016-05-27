package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.entities.MyOrder;
import ru.kpfu.entities.MyUser;
import ru.kpfu.repo.hibernate.impl.MyOrderRepo;
import ru.kpfu.service.UserService;

import java.util.List;

/**
 * Created by Vlad.M on 12.05.2016.
 */
@Controller
@RequestMapping (value = "/cabinet")
public class OrderController {
    @Autowired
    MyOrderRepo orderRepo;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/orders" )
    public String loadcabinet(ModelMap map){
        MyUser user = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        List<MyOrder> orders =orderRepo.getOrders(user);
        System.out.println("_______________"+orders.get(0).getId());
        map.put("orders", orders);
        return "Cabinet";
    }

}
