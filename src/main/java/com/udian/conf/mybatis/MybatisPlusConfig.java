package com.udian.conf.mybatis;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/5/25.
 */
@Configuration
@MapperScan("com.udian.**")
public class MybatisPlusConfig {

    /**
     * 配置分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return  new PaginationInterceptor();
    }

    /**
     * 添加Mybatis-plus提供的其他插件
     */
}
