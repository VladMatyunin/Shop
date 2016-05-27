package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.entities.MyGoods;
import ru.kpfu.service.GoodsService;

import java.util.List;

/**
 * Created by Vlad.M on 03.04.2016.
 */
@RequestMapping(value = "/catalog")
@Controller
public class CatalogController {

    @Autowired
    GoodsService repo;
    private final int CATALOG_ITEMS = 5;
    private String sortType = null;

    @RequestMapping(value = "/{pageNum}", method = RequestMethod.GET)
    public String show(@PathVariable Integer pageNum, ModelMap map) {
        List<MyGoods> catalog = repo.getGoodsRestr(0);

        if (sortType == null || sortType.equals("stock")) {
            if (pageNum != null) {
                catalog = repo.getGoodsRestr(pageNum - 1);
            } else {
                catalog = repo.getGoodsRestr(0);
                pageNum = 0;
            }
        }else if (sortType.equals("cost")) {
            if (pageNum != null) {
                catalog = repo.getGoodsByCost(pageNum - 1);
            } else {
                catalog = repo.getGoodsByCost(0);
                pageNum = 0;
            }
        }else
        if (sortType.equals("category")) {
            if (pageNum != null) {
                catalog = repo.getGoodsByCategory(pageNum - 1);
            } else {
                catalog = repo.getGoodsByCategory(0);
                pageNum = 0;
            }
        } else
        if (sortType.equals("name")) {
            if (pageNum != null) {
                catalog = repo.getGoodsByName(pageNum - 1);
            } else {
                catalog = repo.getGoodsByName(0);
                pageNum = 0;
            }
        }
        map.addAttribute("catalog", catalog);
        map.addAttribute("totalPages", repo.getMenuCount()/5);
        map.addAttribute("page", pageNum);

        return "catalog";
    }
    @RequestMapping(value = "sort/{sorting}", method = RequestMethod.GET)
    public String sort(@PathVariable("sorting") String sorting) {
        sortType = sorting;
        return "redirect:/catalog/1";
    }

}
