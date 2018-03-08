package com.piggame.config;

import com.piggame.entity.User;
import com.piggame.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

/**
 * @Author:zhujie
 * @Date: Create in 15:09 2018/3/7
 **/
public class PresenceChannelInterceptor extends ChannelInterceptorAdapter{

    private static final Logger logger = LoggerFactory.getLogger(PresenceChannelInterceptor.class);

    @Autowired
    private RedisService redisService;

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
        if (sha.getCommand() == null){
            return;
        }
        //这里的sessionId和accountId对应HttpSessionIdHandshakeInterceptor拦截器的存放key
        String seesionId = sha.getSessionAttributes().get("sessionId").toString();
        User user = (User) sha.getSessionAttributes().get("user");
        //判断客户端的连接状态
        switch (sha.getCommand()){
            case CONNECT:
                connect(seesionId,user);
                break;
            case CONNECTED:
                break;
            case DISCONNECT:
                disconnect(seesionId,"111",sha);
                break;
             default:
                 break;

        }
    }

    //连接成功
    private void connect(String sessionId,User user){
        logger.debug(" STOMP Connect [sessionId: " + sessionId + "]");
        //存放至cache
        //String cacheName = ...;
        //若在多个浏览器登录，直接覆盖保存
        //CacheManager.put(cacheName ,cacheName+accountId,sessionId);

    }

    //断开连接
    private void disconnect(String sessionId,String accountId, StompHeaderAccessor sha){
/*        logger.debug("STOMP Disconnect [sessionId: " + sessionId + "]");
        sha.getSessionAttributes().remove(Constants.SESSIONID);
        sha.getSessionAttributes().remove(Constants.SKEY_ACCOUNT_ID);
        //ehcache移除
        String cacheName = CacheConstant.WEBSOCKET_ACCOUNT;
        if (CacheManager.containsKey(cacheName,cacheName+accountId) ){
            CacheManager.remove(cacheName ,cacheName+accountId);
        }*/

    }
}
