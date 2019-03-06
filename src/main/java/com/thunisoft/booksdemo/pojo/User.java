package com.thunisoft.booksdemo.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Table(name = "{db.user}")
@Data
public class User implements Serializable {

    @NotBlank
    @Id
    @Column(name = "R_id")
    private Integer R_id;

    @NotBlank
    @Column(name = "R_Name")
    @Size(max = 255)
    private String R_Name;//用户账号 非空

    @NotBlank
    @Column(name = "R_Pwd")
    @Size(max = 255)
    private String R_Pwd;//用户密码  非空

    @Column(name="R_Gender")
    private Integer R_Gender;//用户性别 可以为空

    @NotBlank
    @Column(name="R_Create")
    private Date R_Create;//用户创建的时间  默认为数据插入的时间

    @Column(name = "R_Img")
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

    //用户注册之时头像默认为空 因此在获取头像时会获取统一的默认头像
    public String getR_Img() {
        if (this.R_Img == null || (this.R_Img.length() == 0)){
            this.setR_Img("\n" +
                    "https://osstestlgy.oss-cn-beijing.aliyuncs.com/default_handsome.jpg?x-oss-process=style/imgforhead");
        }
        return R_Img;
    }
    //对于用户的性别 3表示保密  1代表女性  2代表男性
    public Integer getR_Gender() {
        if(this.R_Gender == null){
            this.setR_Gender(3);
        }
        return R_Gender;
    }
}
