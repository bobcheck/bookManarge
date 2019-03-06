package com.thunisoft.booksdemo.pojo;

import lombok.Data;

//此类用来检验密码修改
@Data
public class UserDTO {

    private String oldPassword;
    private String newPassword;
    private String newPassword2;

    public UserDTO(String oldPassword, String newPassword, String newPassword2){
        this.newPassword = newPassword;
        this.newPassword2 = newPassword2;
        this.oldPassword = oldPassword;
    }

    private UserDTO(){

    }

}
