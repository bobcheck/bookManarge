package com.thunisoft.booksdemo.pojo;

import lombok.Data;


//此类用于修改管理员用户的信息时提交用户使用
@Data
public class UserInfoDto {
    private String id;
    private String name;
    private String image;
    private Integer gender;

    public UserInfoDto(String id, String name, String image, Integer gender){
        this.id = id;
        this.name = name;
        this.image = image;
        this.gender = gender;
    }

    private UserInfoDto(){

    }
}
