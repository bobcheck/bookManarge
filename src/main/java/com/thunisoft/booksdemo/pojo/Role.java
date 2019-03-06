package com.thunisoft.booksdemo.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表单
 * 一个用户可以对应多个角色
 * 用户和角色的对应关系用一个新的表user_role来对应
 */
@Data
public class Role implements Serializable {

    /**
     * 角色id
     */
    private Integer role_Id;
    /**
     * 角色名
     */
    private String role_Name;

    /**
     * 角色描述
     */
    private String role_Desc;

    /**
     * 角色的创建时间
     */
    private Date create_Time;


    private static final long serialVersionUID = 1L;

}
