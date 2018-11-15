package com.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class CustomSessionListenter implements SessionListener {

    @Override
    public void onStart(Session session) {
        System.out.println("-->>CustomSessionListenter.onStart()");
    }

    @Override
    public void onStop(Session session) {
        System.out.println("-->>CustomSessionListenter.onStop()");
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("-->>CustomSessionListenter.onExpiration()");
    }
}
