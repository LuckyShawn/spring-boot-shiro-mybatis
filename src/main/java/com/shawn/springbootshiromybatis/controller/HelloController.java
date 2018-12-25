package com.shawn.springbootshiromybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/21 0021
 */
@RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public Map<String, Object> getMap() {
        return jdbcTemplate.queryForList("select * from department").get(0);
    }


}
