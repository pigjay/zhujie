package com.piggame.config;

import com.piggame.entity.User;
import com.pigganme.framework.config.websocket.SessionAuthHandshakeInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * @Author:zhujie
 * @Date: Create in 10:58 2018/3/1
 **/
@Configuration
@EnableWebSocketMessageBroker
@ConditionalOnWebApplication
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer{
    /**
     * 注册stomp的端点
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 允许使用socketJs方式访问，访问点为webSocketServer，允许跨域
        // 在网页上我们就可以通过这个链接
        // http://localhost:8080/webSocketServer
        // 来和服务器的WebSocket连接
        registry.addEndpoint("/webSocketServer")
                .addInterceptors(sessionAuthHandshakeInterceptor())
                .setHandshakeHandler(new DefaultHandshakeHandler(){
                    @Override
                    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                        return new MyPrincipal((User) attributes.get("user"));
                    }


                })
                .setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(presenceChannelInterceptor());
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(presenceChannelInterceptor());
    }


    /**
     * 配置信息代理
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 订阅Broker名称
        registry.enableSimpleBroker("/queue", "/topic");
        // 全局使用的消息前缀（客户端订阅路径上会体现出来）
        registry.setApplicationDestinationPrefixes("/app");
        // 点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
         registry.setUserDestinationPrefix("/user/");
    }

    private static class MyPrincipal implements Principal{

        private User user;

        public MyPrincipal(User user) {
            this.user = user;
        }

        @Override
        public String getName() {
            return String.valueOf(user.getId());
        }
    }

    @Bean
    public SessionAuthHandshakeInterceptor sessionAuthHandshakeInterceptor(){
        return new SessionAuthHandshakeInterceptor();
    }

    //@Bean
/*    public SessionDisconnectEventListener sessionDisconnectEventListener(){
        return new SessionDisconnectEventListener();
    }*/

    @Bean
    public PresenceChannelInterceptor presenceChannelInterceptor(){
        return new PresenceChannelInterceptor();
    }
}
