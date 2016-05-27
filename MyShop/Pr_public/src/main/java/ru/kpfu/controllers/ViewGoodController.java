package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.service.GoodsService;

/**
 * Created by Vlad.M on 24.04.2016.
 */
@Controller
public class ViewGoodController {
    @Autowired
    GoodsService service;
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, ModelMap map) {
        map.addAttribute("good", service.getGoodsById(id));
        return "viewGood";
    }
}
