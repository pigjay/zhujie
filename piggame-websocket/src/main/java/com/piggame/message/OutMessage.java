package com.piggame.message;

/**
 * 消息推送实体
 * @Author:zhujie
 * @Date: Create in 15:00 2017/11/30
 **/
public class OutMessage {

    private String content;

    public OutMessage() {
    }

    public OutMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
