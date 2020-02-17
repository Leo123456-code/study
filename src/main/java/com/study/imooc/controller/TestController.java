package com.study.imooc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.imooc.config.AliPayConfig;
import com.study.imooc.config.JacksonConfig;
import com.study.imooc.config.SpringBootConfig;
import com.study.imooc.config.WxPayConfig;
import com.study.imooc.vo.Imoocer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *  测试数据注入...
 * created by Leo徐忠春
 * created Time 2020/2/16-20:11
 * email 1437665365@qq.com
 */
@RestController
@Slf4j
@RequestMapping("/study")
@Data
public class TestController {
    @Autowired
    private final SpringBootConfig springBootConfig;
    @Autowired
    private final ObjectMapper mapper;
    @Autowired
    private WxPayConfig wx;
    @Autowired
    private AliPayConfig ali;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Value("${imooc.springboot.version}")
    private String version;
    @Value("${imooc.springboot.name}")
    private String name;

    @GetMapping("/name")
    public String name(){
        log.info("result={},{}",version,name);
        return version+"{数据绑定}"+name;
    }

    @GetMapping("/pefix")
    public void pefix(){
        log.info("result={},{}",springBootConfig.getVersion(),
                springBootConfig.getName());
    }

    @GetMapping("/wx")
    public void wx(){
        log.info("result={},{},{},{},{}",wx.getAppId(),wx.getMchId(),
                wx.getMchKey(),wx.getNotifyUrl(),wx.getReturnUrl());
    }

    @GetMapping("/ali")
    public void ali(){
        log.info("result={},{},{},{},{}",ali.getAppId(),ali.getPayPublicKey(),
                ali.getPrivateKey(),ali.getNotifyUrl(),ali.getReturnUrl());
    }

    @GetMapping("/jackson")
    public Imoocer jackson()throws Exception{
        Imoocer imoocer = Imoocer.builder().name("xzc").age(29).address("hbwh")
                .registerTime(new Date()).build();
        String jsonImoocer = mapper.writeValueAsString(imoocer);
        log.info("序列化={}",gson.toJson(jsonImoocer));
        Imoocer imoocer1 = mapper.readValue(jsonImoocer, Imoocer.class);
        log.info("反序列化={}",gson.toJson(imoocer1));
        return imoocer1;//反序列化
    }


}
