package com.github.flyingglass.demo.service;

import com.github.flyingglass.demo.entity.TestInfo;
import com.github.flyingglass.demo.mapper.TestInfoMapper;
import com.github.flyingglass.phoenix.api.PhoenixServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: fly
 * Created date: 2019/12/23 16:37
 */
@Service
public class TestInfoServiceImpl extends PhoenixServiceImpl<TestInfoMapper, TestInfo> {

}
