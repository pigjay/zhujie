package com.piggame.controller;

import com.piggame.message.Canvas;
import com.piggame.message.ClientMessage;
import com.piggame.message.ServerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * @Author:zhujie
 * @Date: Create in 10:34 2018/3/1
 **/
@Controller
public class WebSocketAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/mousedown")
    @SendTo("/topic/mousedown")
    public Canvas mousedown(Canvas canvas){
        logger.info("x:"+ canvas.getX() + " y:" + canvas.getY());
        return canvas;
    }

    @MessageMapping("/mousemove")
    @SendTo("/topic/mousemove")
    public Canvas mousemove(Canvas canvas){
        logger.info("x:"+ canvas.getX() + " y:" + canvas.getY());
        return canvas;
    }

}
