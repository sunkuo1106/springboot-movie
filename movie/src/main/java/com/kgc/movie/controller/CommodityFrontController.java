package com.kgc.movie.controller;

import com.kgc.movie.pojo.Commodity;
import com.kgc.movie.pojo.CommodityFront;
import com.kgc.movie.service.CommodityFrontService;
import com.kgc.movie.service.CommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-11-24 15:53
 */
@Controller
public class CommodityFrontController {
    @Resource
    CommodityFrontService commodityFrontService;
    @Resource
    CommodityService commodityService;
    @RequestMapping("/frontById")
    @ResponseBody
    public Map<String,Object> frontById(Integer enterId,HttpSession session){
        Map<String,Object> map=new HashMap<>();
        CommodityFront commodityFront = commodityFrontService.frontById(enterId);
        String commodityName=commodityFront.getCommodityName();
        String[] split = commodityName.split(",");
        List list=new ArrayList();
        for (int i = 0; i < split.length; i++) {
            Integer index=split[i].indexOf("*");
            String name=split[i].substring(0,index);
            List<Commodity> commodities= commodityService.selectByImg(name);
            System.out.println(commodities.get(0).getPicture());
            list.add(commodities.get(0).getPicture());
        }
            session.setAttribute("list",list);

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
