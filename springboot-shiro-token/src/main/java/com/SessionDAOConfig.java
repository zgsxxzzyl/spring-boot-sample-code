package com;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SessionDAOConfig extends EnterpriseCacheSessionDAO {
    private Map<Serializable, Session> sessionMap = new HashMap<>();

    @Override
    protected Serializable doCreate(Session session) {
        return super.doCreate(session);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession) {
            if (((ValidatingSession) session).isValid()) {
                sessionMap.put(session.getId(), session);
            } else {
                sessionMap.remove(session.getId());
            }
        } else {
            sessionMap.put(session.getId(), session);
        }
    }

    @Override
    protected void doDelete(Session session) {
        sessionMap.remove(session.getId());
    }
}
