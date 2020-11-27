package com.kgc.movie.controller;

import com.kgc.movie.pojo.CommodityFront;
import com.kgc.movie.service.CommodityFrontService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-11-24 15:53
 */
@Controller
public class CommodityFrontController {
    @Resource
    CommodityFrontService commodityFrontService;
    @RequestMapping("/frontById")
    @ResponseBody
    public Map<String,Object> frontById(Integer enterId){
        Map<String,Object> map=new HashMap<>();
        CommodityFront commodityFront = commodityFrontService.frontById(enterId);
        map.put("CommodityName",commodityFront.getCommodityName());
        return map;
    }
    @RequestMapping("/addFront")
    @ResponseBody
    public Map<String,Object> addFront(HttpSession session){
        Map<String,Object> map=new HashMap<>();
        CommodityFront commodityFront =(CommodityFront) session.getAttribute("commodityFront");
        commodityFrontService.addFront(commodityFront);
        return map;
    }
}
