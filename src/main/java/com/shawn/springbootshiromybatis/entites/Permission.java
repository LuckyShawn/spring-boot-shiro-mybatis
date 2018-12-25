package com.shawn.springbootshiromybatis.entites;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 7160557680614732403L;
    private Integer id;
    private String url;
    private String name;
}
