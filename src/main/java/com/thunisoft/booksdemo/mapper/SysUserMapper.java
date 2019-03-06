package com.thunisoft.booksdemo.mapper;

import com.thunisoft.artery.data.mybatis.page.BaseMapper;
import com.thunisoft.booksdemo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<User, String> {

    public User selectUser(User user);

    public User getUserById(Integer id);

    public User getUserByName(String name);

    public int insertUser(User user);

    public int updateUser(User user);

}
