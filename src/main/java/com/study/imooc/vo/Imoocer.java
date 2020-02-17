package com.study.imooc.vo;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by Leo徐忠春
 * created Time 2020/2/16-23:06
 * email 1437665365@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//忽略集合里面所有属性
@JsonIgnoreProperties({"address"})
public class Imoocer {

    private String name;

    private Integer age;
//    @JsonIgnore
    //忽略这个属性
    private String address;
    //json序列化指定别名
    @JsonProperty("rs")
    //日期格式
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;
}
