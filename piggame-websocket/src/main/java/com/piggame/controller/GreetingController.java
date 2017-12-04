package com.piggame.controller;

import com.piggame.message.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 聊天控制器
 * @Author:zhujie
 * @Date: Create in 14:49 2017/11/30
 **/
@Controller
public class GreetingController {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    /**
     * 表示服务端可以接收客户端通过主题“/app/hello”发送过来的消息，
     * 客户端需要在主题"/topic/hello"上监听并接收服务端发回的消息
     * @param topic
     * @param headers
     */
    @MessageMapping("/hello") //"/hello"为WebSocketConfig类中registerStompEndpoints()方法配置的
    @SendTo("/topic/greetings")
    public void greeting(String topic,Map<String,Object> headers){
        System.out.println("connected successfully....");
        System.out.println(topic);
        System.out.println(headers);
    }

    /**
     * 这里用的是@SendToUser，这就是发送给单一客户端的标志。本例中，
     * 客户端接收一对一消息的主题应该是“/user/” + 用户Id + “/message” ,
     * 这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id
     * 并且服务端知道每个用户的id就行。
     * @return
     */
    @MessageMapping("/message")
    @SendToUser("/message")
    public Greeting handlerSubcride(){
        System.out.println("this is the @SubscribeMapping('/marco')");
        return new Greeting("I am a msg from SubcribeMapping('/macro').");
    }

    /**
     * 测试对指定用户发送消息方法
     * @return
     */
    @RequestMapping(path = "/send",method = RequestMethod.GET)
    public Greeting send(){
        simpMessageSendingOperations.convertAndSendToUser("1","/message",new Greeting("I am a msg from SubscribeMapping('/macro')."));
        return new Greeting("I am a msg from SubcribeMapping('/macro').");
    }
}
