package com.thunisoft.booksdemo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }
    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置指定的登录页面
        shiroFilterFactoryBean.setLoginUrl("/index");
        //登录成功后跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/home");
        //设置未授权返回的界面  未授权则返回登录页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/");
        Map<String, String> map = new HashMap<String, String>();
        //首先配置不会拦截的页面  包括登录注册页面 静态资源等 过滤链自上而下开始判断
        //<!-- authc:url都必须认证通过才可以访问; anon:url可以匿名访问-->
        map.put("/index","anon");
        map.put("/register", "anon");
        map.put("/static/**", "anon");
        map.put("/webjars/**","anon");

        map.put("/borrow", "authc");
        map.put("/home","authc");
        map.put("/info/**","authc");
        map.put("/users/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}

