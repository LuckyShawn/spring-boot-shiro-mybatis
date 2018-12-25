package com.shawn.springbootshiromybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/indexTest")
    public String indexTest(){
        return "index";
    }

    @RequestMapping("/errorTest")
    public String errorTest() throws Exception {
        throw new Exception("发生错误");
    }
}
