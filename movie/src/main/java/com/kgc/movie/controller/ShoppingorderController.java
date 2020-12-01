package com.kgc.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2020-12-01 10:15
 */
@Controller
public class ShoppingorderController {

    @RequestMapping("/todemo")
    public String todemo(){
        return "demo";
    }
}
