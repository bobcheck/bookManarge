package com.thunisoft.booksdemo.bean;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "{db.user}")
@Data
public class User implements Serializable {

    private Integer R_id;//用户id 非空
    private String R_Name;//用户账号 非空
    private String R_Pwd;//用户密码  非空
    private Integer R_Gender;//用户性别 可以为空
    private Date R_Create;//用户创建的时间  默认为数据插入的时间
    private String R_Img;//用户的头像  默认为Null 当渲染的时候如果R_Img为空则渲染默认的图片,当用户上传自己的图片时才执行sql语句

    private static final long serialVersionUID = 1L;

    private User(){

    }

    public User(String R_Name, String R_Pwd, Integer R_Gender)
    {
        this.R_Gender = R_Gender;
        this.R_Name = R_Name;
        this.R_Pwd = R_Pwd;
    }

}
