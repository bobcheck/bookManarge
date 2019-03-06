package com.thunisoft.booksdemo.controller;

import com.thunisoft.artery.data.annotation.ExceptionTips;
import com.thunisoft.booksdemo.pojo.Result;
import com.thunisoft.booksdemo.pojo.User;
import com.thunisoft.booksdemo.pojo.UserDTO;
import com.thunisoft.booksdemo.pojo.UserInfoDto;
import com.thunisoft.booksdemo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员账户管理控制器
 * 包括查看个人信息，修改个人信息等功能
 */
@Controller
public class AccountController {

    @Autowired
    private ISysUserService sysUserService;

    //用户查看个人信息主页
    @GetMapping(value = "/info")
    public String info(HttpServletRequest request, Model model){
        model.addAttribute("curUser", sysUserService.getCurrentUser());
        request.setAttribute("id", sysUserService.getCurrentUserId());
        request.setAttribute("name", sysUserService.getCurrentUser().getR_Name());
        request.setAttribute("gender", sysUserService.getCurrentUser().getR_Gender());
        request.setAttribute("image", sysUserService.getCurrentUser().getR_Img());
        return "Account/info";
    }

    //将个人信息数据以json形式传输
    @GetMapping(value = "/info/self")
    @ExceptionTips("获取个人信息异常")
    @ResponseBody
    public List<User> selfInfo(){
        List<User> users = new ArrayList<>();
        users.add(sysUserService.getCurrentUser());
        return users;
    }

    //对用户的个人信息进行修改 在这里主要实现修改密码功能 更换头像等功能后期再实现
    @GetMapping(value = "/info/update")
    public String update(Model model){
        model.addAttribute("curUser", sysUserService.getCurrentUser());
        return "Account/resetPwd";
    }

    //提交修改的密码表单 其中
    @PostMapping(value = "/info/doUpdate")
    @ResponseBody
    @ExceptionTips("修改密码异常")
    public Result doUpdate(@RequestBody UserDTO userDTO){
        Result result = new Result(200, "修改密码成功");
        User user1 = sysUserService.getCurrentUser();
        //首先验证输入的旧密码是否相同 如果不等则直接返回错误不在进行更新操作
        if(!(user1.getR_Pwd().equals(userDTO.getOldPassword())))
        {
            result.setCode(201);
            result.setMessage("原密码输入错误");
            return result;
        }
        //接下来来判断输入的新旧密码是否一致
        if(!(userDTO.getNewPassword().equals(userDTO.getNewPassword2())))
        {
            result.setCode(202);
            result.setMessage("您两次输入的新密码不一致");
            return result;
        }
        user1.setR_Pwd(userDTO.getNewPassword());
        if (sysUserService.updateByPrimaryKey(user1) > 0){
            return result;
        }else{
            result.setCode(203);
            result.setMessage("修改密码失败");
            return result;
        }
    }



}
