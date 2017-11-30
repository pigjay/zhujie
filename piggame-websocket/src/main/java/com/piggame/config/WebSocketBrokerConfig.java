package com.piggame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 启用STOMP协议WebSocket配置
 * @Author:zhujie
 * @Date: Create in 11:19 2017/11/30
 **/
@Configuration
@EnableWebMvc
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        System.out.println("注册");
        stompEndpointRegistry.addEndpoint("/hello").withSockJS();//注册端点,和普通服务端的/log一样的
        //withSockJS()表示支持socktJS访问,在浏览器中使用
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        System.out.println("启动");
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");//格式前缀
    }

    @Bean
    public SocketSessionRegistry socketSessionRegistry(){
        return new SocketSessionRegistry();
    }

    @Bean
    public STOMPConnectEventListener STOMPConnectEventListener(){
        return new STOMPConnectEventListener();
    }

}
