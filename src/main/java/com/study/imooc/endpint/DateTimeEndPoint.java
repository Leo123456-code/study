package com.study.imooc.endpint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Actuactor
 *  自定义事件端点
 * created by Leo徐忠春
 * created Time 2020/2/17-0:13
 * email 1437665365@qq.com
 */
@Endpoint(id = "datetime")
public class DateTimeEndPoint {
    private String format="yyyy-MM-dd HH:mm:ss";
    /**
     * 用来显示监控指标
     * imooc/actuator/datetime
     */
    @ReadOperation
    public Map<String,Object> info(){
        Map<String, Object> info = new HashMap<>();
        info.put("name","qinyi");
        info.put("age","19");
        info.put("datetime",new SimpleDateFormat(format).format(new Date()));
    return info;
    }
    /**
     * 动态更改监控指标
     */
    @WriteOperation
    public void setFormat(String format){
        this.format=format;
    }
}
