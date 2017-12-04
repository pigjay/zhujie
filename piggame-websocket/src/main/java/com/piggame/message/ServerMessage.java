package com.piggame.message;

/**
 * @Author:zhujie
 * @Date: Create in 18:19 2017/12/4
 **/
public class ServerMessage {

    private String responeseMessage;

    public ServerMessage(String responeseMessage) {
        this.responeseMessage = responeseMessage;
    }

    public String getResponeseMessage() {
        return responeseMessage;
    }

    public void setResponeseMessage(String responeseMessage) {
        this.responeseMessage = responeseMessage;
    }
}
