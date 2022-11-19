package com.lzj.demo.config.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author 林子键
 * @version 1.0
 */
@Configuration
@MapperScan("com.lzj.demo.dao")
public class DataSourceConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录账号密码配置
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        //增加配置
        objectObjectHashMap.put("loginUsername", "admin"); //管理员账号密码
        objectObjectHashMap.put("loginPassword", "123456");

        statViewServletServletRegistrationBean.setInitParameters(objectObjectHashMap);
        return statViewServletServletRegistrationBean;
    }
}
