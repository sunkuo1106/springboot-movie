package com.kgc.movie.controller;

import com.kgc.movie.tools.JuheDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {



    @RequestMapping("/selectCityMovie")
    @ResponseBody
    //根据城市查询当天上映所有电影
    public Map<String,Object> selectCityMovie(String cityIdStr){
        Map<String,Object> map=new HashMap<>();
        //获取到城市Id
        int cityId=Integer.parseInt(cityIdStr);
        Object o= JuheDemo.getRequest5(cityId);
        map.put("o",o);
        return map;
    }

    @RequestMapping("/selectByMovie")
    @ResponseBody
    //按电影名称检索影片信息
    public static Map<String,Object> selectByMovie(){
        Map<String,Object> map=new HashMap<>();
        Object o= JuheDemo.getRequest1("1917");
        map.put("o",o);
        return map;
    }

    @RequestMapping("/toZfsuccess")
    public String toZfsuccess(){
        return "zf-success";
    }

}
