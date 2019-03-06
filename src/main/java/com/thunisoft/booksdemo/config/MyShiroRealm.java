package com.thunisoft.booksdemo.config;

import com.thunisoft.booksdemo.pojo.User;
import com.thunisoft.booksdemo.mapper.SysUserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    //用来查询用户信息
    @Autowired
    private SysUserMapper sysUserMapper;

    //角色权限和对应权限的添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = sysUserMapper.getUserByName(username);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //根据用户id查询角色
        //为了测试功能不从数据库中查询数据直接赋值
        Set<String> roleSet = new HashSet<>();
        roleSet.add("manager");
        simpleAuthorizationInfo.setRoles(roleSet);
        Set<String> perSet = new HashSet<>();
        perSet.add("all");
        simpleAuthorizationInfo.setStringPermissions(perSet);
        return simpleAuthorizationInfo;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = sysUserMapper.getUserByName(username);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getR_Pwd(),
                getName()
        );
        return simpleAuthenticationInfo;
    }
}
