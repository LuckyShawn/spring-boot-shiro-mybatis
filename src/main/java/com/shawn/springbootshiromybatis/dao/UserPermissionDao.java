package com.shawn.springbootshiromybatis.dao;

import com.shawn.springbootshiromybatis.entites.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionDao {
    List<Permission> findByUserName(String userName);
}
