package com.study.imooc;



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
//表示使用test里面yml文件
@ActiveProfiles("test")
public class ImoocSpringStudyApplicationTests {

    @Test
    public void contextLoads() {
    }

}
