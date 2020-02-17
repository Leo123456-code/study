package com.study.imooc.service.Impl;

import com.study.imooc.service.ISplitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by Leo徐忠春
 * created Time 2020/2/17-1:17
 * email 1437665365@qq.com
 */
@Slf4j
@Service
public class SplitServiceImpl implements ISplitService {

    @SuppressWarnings("all")
    @Override
    public List<String> split(String value) {
        return Stream.of(StringUtils.split(value,",")).
                collect(Collectors.toList());
    }
}
