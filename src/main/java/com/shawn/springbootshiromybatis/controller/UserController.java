package com.shawn.springbootshiromybatis.controller;

import com.shawn.springbootshiromybatis.dao.UserDao;
import com.shawn.springbootshiromybatis.entites.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequiresPermissions("user:user")
    @RequestMapping("list")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        Map<Integer,Object> map = new HashMap<>();
        List<User> list = userDao.list();
        for(User user : list){
            map.put(user.getId(),user.getUserName());
        }
        model.addAttribute("users",map);
        return "user";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public String userAdd(Model model) {
        model.addAttribute("value", "新增用户");
        return "user";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public String userDelete(Model model) {
        model.addAttribute("value", "删除用户");
        return "user";
    }
}
