package com.shawn.springbootshiromybatis.entites;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@Data
public class Role implements Serializable{

    private static final long serialVersionUID = -227437593919820521L;
    private Integer id;
    private String name;
    private String memo;

}
