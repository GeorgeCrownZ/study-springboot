package com.zc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //  后台监控
    //  因为springboot 内置了 servlet容器，所以没有web.xml。如果想用就要用替代方法 ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        //  后台需要有人登录，账号密码配置
        HashMap<String, String> initParamters = new HashMap<String, String>();

        //  增加配置.
        //  登录key 是固定的 loginUsername loginPassword
        initParamters.put("loginUsername", "admin");
        initParamters.put("loginPassword", "123456");

        //  允许谁可以访问 value为空则所有人可访问，如果为localhost则只有本机可以访问
        initParamters.put("allow", "");

        //  禁止谁来访问
        initParamters.put("zhaocan", "192.168.44444.55555");

        bean.setInitParameters(initParamters);   //设置初始化参数
        return bean;
    }

    //  filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<Filter>();

        bean.setFilter(new WebStatFilter());

        //  可以过滤哪些请求
        HashMap<String, String> maps = new HashMap<>();

        //  这些东西不进行统计
        maps.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(maps);

        return bean;
    }
}
