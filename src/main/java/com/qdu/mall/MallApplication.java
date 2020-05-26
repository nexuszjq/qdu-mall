package com.qdu.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: com.qdu.mall.MallApplication.java
 * @Description: 启动类
 * @author: ZhangJunqing
 * @date:  2020-04-12 11:44
 * @version V1.0
 */
@MapperScan("com.qdu.mall.dao")
@SpringBootApplication
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }
}
