package com.kgc.movie.controller;

import com.kgc.movie.pojo.Commodity;
import com.kgc.movie.service.CommodityService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-17 10:03
 */
@Controller
public class ShoppingController {
    @Resource
    CommodityService commodityService;
    @RequestMapping("/toshopping")
    public String toshopping(Model model, HttpServletRequest request){
        List<Commodity> commodities = commodityService.selectAll();
        System.out.println(commodities.toString());
        model.addAttribute("commodities",commodities);
       /* request.setAttribute("commodities",commodities);*/
        return "shopping";
    }
    @RequestMapping("/todetails")
    public String todetails(){
        return "details";
    }
}
