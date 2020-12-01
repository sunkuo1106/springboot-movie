package com.kgc.movie.controller;

import com.kgc.movie.pojo.CommodityTable;
import com.kgc.movie.pojo.Goods;
import com.kgc.movie.pojo.User;
import com.kgc.movie.service.CommodityTableService;
import com.kgc.movie.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Resource
    GoodsService goodsService;

    @RequestMapping("/toShopping")
    public String toShopping(Model model, HttpServletRequest request){
        return "shopping";
    }

    @RequestMapping("/toShopping_cart")
    public String toShopping_cart(Model model, HttpServletRequest request){
        return "shopping_cart";
    }

    @RequestMapping("/toTest1")
    @ResponseBody
    public Map<String,List<CommodityTable>> toTest1(Model model, HttpServletRequest request){
        Map<String,List<CommodityTable>> map=new HashMap<>();
        List<CommodityTable> commodityTables = commodityTableService.selectAllCommodity();
        map.put("data",commodityTables);
        return map;
    }

    //添加购物车
    @RequestMapping("/doAddShoppingCart")
    @ResponseBody
    public Map<String,Object> doAddShoppingCart(Integer id, HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        Map<String,Object>map=new HashMap<>();
        System.out.println("商品id为"+id);
        //根据商品id查询出该商品
        CommodityTable commodityTable = commodityTableService.selectByCommodity(id);
        //添加购物车页面前判断是否存在  如果存在走修改方法
        boolean flag = goodsService.selectById(user.getUname(), commodityTable.getCommodityName());
        if(flag){
            int i=goodsService.updateGoodsNums(user.getUname(), commodityTable.getCommodityName());
            if(i==0){//如果i==0 证明数量已经到了10无法继续添加购物车
                map.put("flag",true);
            }
        }else{
            Goods goods=new Goods();
            goods.setUserName(user.getUname());
            goods.setGoodsName(commodityTable.getCommodityName());
            goods.setGoodsNums(1);
            goods.setGoodsPicture(commodityTable.getCommodityPicture());
            goods.setGoodsPrice(commodityTable.getCommodityPrice());
            goodsService.AddGoods(goods);
        }
        return map;
    }
}
