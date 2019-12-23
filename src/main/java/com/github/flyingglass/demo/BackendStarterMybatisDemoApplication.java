package com.github.flyingglass.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.flyingglass.demo.entity.TestInfo;
import com.github.flyingglass.demo.entity.UserInfo;
import com.github.flyingglass.demo.mapper.TestInfoMapper;
import com.github.flyingglass.demo.mapper.UserInfoMapper;
import com.github.flyingglass.demo.service.TestInfoServiceImpl;
import com.github.flyingglass.demo.service.UserInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;


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


        /**
         * MySQL
         */
        final int size = 100;

        // Redis Cache Test
        UserInfoMapper mapper = applicationContext.getBean("userInfoMapper", UserInfoMapper.class);

        // Batch Test
        UserInfoServiceImpl service = applicationContext.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);


        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            UserInfo userInfo = new UserInfo().setUsername("u"+i).setPassword("p"+i);
            userInfo.setId(Long.valueOf(i));
            list.add(userInfo);
        }
        service.saveOrUpdateBatch(list);



        mapper.selectList(Wrappers.emptyWrapper());

        // cache
        mapper.selectList(Wrappers.emptyWrapper());


        // cache
        mapper.selectList(Wrappers.emptyWrapper());


        /**
         * Phoenix
         */

        // Phoenix Cache Test
        TestInfoMapper mapper1 = applicationContext.getBean("testInfoMapper", TestInfoMapper.class);
        mapper1.selectList(Wrappers.emptyWrapper());


        TestInfoServiceImpl service1 = applicationContext.getBean("testInfoServiceImpl", TestInfoServiceImpl.class);

        List<TestInfo> list1 = new ArrayList<>();
        // Batch Test
        for (int i = 0; i < size; i++) {
            TestInfo testInfo = new TestInfo()
                    .setId(Long.valueOf(i))
                    .setName("upsert batch");
            list1.add(testInfo);
        }
        service1.saveBatch(list1);

        // foreach
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
