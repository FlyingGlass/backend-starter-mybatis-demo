package com.github.flyingglass.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.github.flyingglass.demo.entity.TestInfo;
import com.github.flyingglass.mybatis.cache.LoggingRedisCache;
import com.github.flyingglass.phoenix.api.PhoenixMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author ly
 * date 2019/12/16 20:12
 * desc:
 */
@CacheNamespace(
        implementation = LoggingRedisCache.class
)
@DS("phoenix")
public interface TestInfoMapper extends PhoenixMapper<TestInfo> {
//    @Insert(
//            "UPSERT INTO TEST_INFO " +
//                    "(ID, NAME, PHONE, POSITION, DEPARTMENT, COMPANY, FILE_NAME, POS_DEP_COM, GMT_CREATE, GMT_UPDATED) " +
//                    "VALUES(#{t.id},#{t.name},#{t.phone},#{t.position},#{t.department},#{t.company}," +
//                    "#{t.fileName},#{t.posDepCom},#{t.gmtCreate},#{t.gmtUpdated})"
//    )
//    void addTestInfo(@Param("t") TestInfo t);
}
