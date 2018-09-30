package com.example.action;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/websocket")
public class WebSocket {
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("--> onOpen");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("--> onMessage : " + message);
    }

    @OnClose
    public void onClose() {
        System.out.println("--> onClose");

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("--> onError");
        throwable.printStackTrace();
    }
}
