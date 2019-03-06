package com.thunisoft.booksdemo.service;

import com.thunisoft.booksdemo.pojo.User;

public interface ISysUserService {

    /**
     * 查询当前登录的用户
     * @return
     */
    public User getCurrentUser();


    /**
     * 查询当前登录用户的ID
     * @return
     */
    public Integer getCurrentUserId();


    /**
     * 根据主键更新信息
     *
     * @param
     * @return
     */
    public int updateByPrimaryKey(User user);

}
