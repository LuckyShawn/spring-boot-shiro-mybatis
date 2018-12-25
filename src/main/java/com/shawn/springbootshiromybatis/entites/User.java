package com.shawn.springbootshiromybatis.entites;

import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@Data
public class User {
    private static final long serialVersionUID = -5440372534300871944L;

    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;
}
