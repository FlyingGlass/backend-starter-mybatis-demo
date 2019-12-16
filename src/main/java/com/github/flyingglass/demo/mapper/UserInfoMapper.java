package com.github.flyingglass.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.flyingglass.demo.entity.UserInfo;
import com.github.flyingglass.mybatis.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Property;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Generator
 * @since 2019-07-15
 */
@CacheNamespace(
//        implementation = MybatisRedisCache.class
        implementation = MybatisRedisCache.class,
        properties = { @Property(
                name = "flushInterval",
                value = "10000"
        )}
)
//@DS("slave_1")
//@DS("phoenix")
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
