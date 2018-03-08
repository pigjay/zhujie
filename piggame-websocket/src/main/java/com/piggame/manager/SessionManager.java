package com.piggame.manager;

import com.piggame.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:zhujie
 * @Date: Create in 18:31 2018/3/8
 **/
public class SessionManager {

    @Autowired
    private RedisService redisService;

    private static final String WEBSOCKETSESSION = "websocket:session:";

    public void addSession(String sessionId,String userId){
        redisService.hmSet(WEBSOCKETSESSION,userId,sessionId);
    }

    public String getSessionId(String usrerId){
        return (String) redisService.hmGet(WEBSOCKETSESSION,usrerId);
    }

}
