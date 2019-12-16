package com.github.flyingglass.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.flyingglass.demo.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Administrator
 */
@Slf4j
@MapperScan(basePackages = "com.github.flyingglass.demo.mapper")
@SpringBootApplication(
        exclude = DruidDataSourceAutoConfigure.class
)
public class BackendStarterMybatisDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BackendStarterMybatisDemoApplication.class, args);

        UserInfoMapper mapper = applicationContext.getBean("userInfoMapper", UserInfoMapper.class);

        mapper.selectList(Wrappers.emptyWrapper());

        // cache
        mapper.selectList(Wrappers.emptyWrapper());


        // cache
        mapper.selectList(Wrappers.emptyWrapper());

    }

}
