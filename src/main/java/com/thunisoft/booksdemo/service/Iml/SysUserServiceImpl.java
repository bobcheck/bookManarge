package com.thunisoft.booksdemo.service.Iml;

import com.thunisoft.booksdemo.mapper.SysUserMapper;
import com.thunisoft.booksdemo.pojo.User;
import com.thunisoft.booksdemo.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    @Override
    public Integer getCurrentUserId(){
        return  getCurrentUser().getR_id();
    }

    @Override
    public int updateByPrimaryKey(User user){
        return sysUserMapper.updateByPrimaryKey(user);
    }

}
