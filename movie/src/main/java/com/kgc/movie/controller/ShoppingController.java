package com.kgc.movie.controller;

import com.kgc.movie.pojo.Commodity;
import com.kgc.movie.pojo.CommodityFront;
import com.kgc.movie.pojo.CommodityTable;
import com.kgc.movie.service.CommodityTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunkuo
 * @create 2020-11-30 10:50
 */
@Controller
public class ShoppingController {

    @Resource
    CommodityTableService commodityTableService;

    @RequestMapping("/toTest1")
    @ResponseBody
    public Map<String,List<CommodityTable>> toTest1(Model model, HttpServletRequest request){
        Map<String,List<CommodityTable>> map=new HashMap<>();
        List<CommodityTable> commodityTables = commodityTableService.selectAllCommodity();
        map.put("data",commodityTables);
        return map;
    }

    @RequestMapping("/toTest")
    public String toTest(Model model, HttpServletRequest request){
        return "test";
    }

    @RequestMapping("/toShopping")
    public String toShopping(Model model, HttpServletRequest request){
        return "shopping";
    }
    @RequestMapping("/toShopping_cart")
    public String toShopping_cart(Model model, HttpServletRequest request){
        return "shopping_cart";
    }

    //添加购物车
    @RequestMapping("/doAddShoppingCart")
    @ResponseBody
    public Map<String,Object> doAddShoppingCart(Integer id){
        Map<String,Object>map=new HashMap<>();
        System.out.println("商品id为"+id);
        CommodityTable commodityTable = commodityTableService.selectByCommodity(id);

        return map;
    }
}
