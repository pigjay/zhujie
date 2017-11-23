package com.piggame;

import com.pigganme.framework.config.logAspect.WebLogAspect;
import com.pigganme.framework.config.shiro.ShiroConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.pigganme.framework.config.data.DataSourceConfig;
import com.pigganme.framework.config.data.DruidConfig;
import com.pigganme.framework.config.redis.RedisConfig;
import com.pigganme.framework.config.session.SessionConfig;
import com.pigganme.framework.exception.GlobalExceptionHandler;

@Import({
        DruidConfig.class,
        DataSourceConfig.class,
        RedisConfig.class,
        SessionConfig.class,
        ShiroConfig.class,
        WebLogAspect.class,
        GlobalExceptionHandler.class
})
@SpringBootApplication
@MapperScan(basePackages = "com.piggame.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
