package com.shawn.springbootshiromybatis.dao;

import com.shawn.springbootshiromybatis.entites.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@Mapper
public interface UserRoleDao {
    List<Role> findByUserName(String userName);
}
