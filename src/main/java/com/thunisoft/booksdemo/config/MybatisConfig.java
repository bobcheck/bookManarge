package com.thunisoft.booksdemo.config;


import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

//当bean类中的属性命名规则不同之时会出现获取不到数据的情况  为了解决这一问题我们采取修改自定义配置类
@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    public ConfigurationCustomizer configurationCustomizer(){

        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                //开启驼峰命名法的自动匹配
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
