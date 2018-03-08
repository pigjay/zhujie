package com.piggame.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * @Author:zhujie
 * @Date: Create in 17:20 2018/3/7
 **/
public class SessionDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent>{

    private Logger logger = LoggerFactory.getLogger(SessionDisconnectEventListener.class);

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        logger.info("sessionId:" + sessionDisconnectEvent.getSessionId());
    }
}
