package com.piggame.controller;

import com.piggame.entity.Room;
import com.piggame.entity.User;
import com.piggame.manager.RoomManager;
import com.piggame.message.Canvas;
import com.piggame.message.ClientMessage;
import com.piggame.message.ServerMessage;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author:zhujie
 * @Date: Create in 10:34 2018/3/1
 **/
@Controller
@RequestMapping("/room")
public class WebSocketAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/buildRoom")
    public @ResponseBody Object buildRoom(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return RoomManager.buildRoom(user);
    }

/*    @MessageMapping("/inviteFriend")
    public ClientMessage inviteFriend(ClientMessage message){

    }*/

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

    @MessageMapping("/message")
    public void sendToUser(ClientMessage message){
        logger.info(message.getName()+message.getUserId());
        simpMessagingTemplate.convertAndSendToUser(message.getUserId(),"/topic/message",message.getName());
    }

}
