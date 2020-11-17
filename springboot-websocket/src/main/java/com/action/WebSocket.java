package com.action;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint(value = "/websocket")
public class WebSocket {
    private Session session;
    private static int count = 0;
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("--> onOpen");
    }

    private void addOnlineCount() {
        count++;
        System.out.println("--> Count : " + count);
        sendMessageAll(String.valueOf(count));
    }

    private void removeOnlineCount() {
        count--;
        System.out.println("--> Count : " + count);
        sendMessageAll(String.valueOf(count));
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("--> onMessage : " + message);
        sendMessage("--> Receive : " + message);
    }

    @OnClose
    public void onClose() {
        System.out.println("--> onClose");
        webSocketSet.remove(this);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("--> onError");
        throwable.printStackTrace();
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageAll(String message) {
        for (WebSocket webSocket : webSocketSet) {
            webSocket.sendMessage(message);
        }
    }

}
