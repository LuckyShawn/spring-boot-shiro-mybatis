package com.shawn.springbootshiromybatis.dao;

import com.shawn.springbootshiromybatis.entites.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@Mapper
public interface UserDao {

    User findByUserName(String userName);

    List<User> list();
}
