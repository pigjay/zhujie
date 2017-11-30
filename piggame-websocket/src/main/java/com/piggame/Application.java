package com.piggame;

import com.piggame.config.WebSocketBrokerConfig;
import com.piggame.config.WebSocketConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.socket.config.annotation.DelegatingWebSocketConfiguration;

/**
 * @Author:zhujie
 * @Date: Create in 11:34 2017/11/30
 **/
@Import({
        WebSocketBrokerConfig.class,
        //WebSocketConfig.class
})
@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
        })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
