package com.thunisoft.booksdemo.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基于RBAC的权限控制
 * 权限类
 */
@Data
public class Permission implements Serializable {

    /**
     * 权限ID
     */
    private Integer P_Id;
    /**
     * 权限名称
     */
    private String P_Name;
    /**
     * 权限URL
     */
    private String P_URL;
    /**
     * 权限的创建时间
     */
    private Date create_Time;

    private static final long serialVersionUID = 1L;

}
