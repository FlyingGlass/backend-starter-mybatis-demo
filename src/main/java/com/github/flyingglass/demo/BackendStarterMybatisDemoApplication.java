package com.github.flyingglass.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.flyingglass.demo.entity.TestInfo;
import com.github.flyingglass.demo.mapper.TestInfoMapper;
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
        // 设置HADOOP_HOME路径
        System.setProperty("hadoop.home.dir", System.getProperty("user.dir"));

        ApplicationContext applicationContext = SpringApplication.run(BackendStarterMybatisDemoApplication.class, args);

        // Redis Cache Test
        UserInfoMapper mapper = applicationContext.getBean("userInfoMapper", UserInfoMapper.class);

        mapper.selectList(Wrappers.emptyWrapper());

        // cache
        mapper.selectList(Wrappers.emptyWrapper());


        // cache
        mapper.selectList(Wrappers.emptyWrapper());


        // Phoenix Cache Test
        TestInfoMapper mapper1 = applicationContext.getBean("testInfoMapper", TestInfoMapper.class);
        mapper1.selectList(Wrappers.emptyWrapper());

        TestInfo testInfo = new TestInfo()
                .setId(102L)
                .setName("101");


        // Phoenix upsert test
        mapper1.upsert(testInfo);

        mapper1.selectList(Wrappers.emptyWrapper());

        // cache
        mapper1.selectList(Wrappers.emptyWrapper());
    }

}
