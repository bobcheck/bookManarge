package com.thunisoft.booksdemo.Controller;


import com.thunisoft.booksdemo.bean.User;
import com.thunisoft.booksdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userMapper.selectAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") Integer id)
    {
        return userMapper.getUserById(id);
    }
}
