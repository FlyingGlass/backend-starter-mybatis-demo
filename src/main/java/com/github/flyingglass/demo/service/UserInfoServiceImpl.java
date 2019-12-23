package com.github.flyingglass.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.flyingglass.demo.entity.UserInfo;
import com.github.flyingglass.demo.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author: fly
 * Created date: 2019/12/23 16:39
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> {
}
