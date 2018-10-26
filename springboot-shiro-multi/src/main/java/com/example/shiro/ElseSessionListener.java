package com.example.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

public class ElseSessionListener extends SessionListenerAdapter {
    @Override
    public void onStart(Session session) {
        System.out.println("-->>ElseSessionListener.onStart()");
        super.onStart(session);
    }

    @Override
    public void onStop(Session session) {
        System.out.println("-->>ElseSessionListener.onStop()");
        super.onStop(session);
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("-->>ElseSessionListener.onExpiration()");
        super.onExpiration(session);
    }
}
