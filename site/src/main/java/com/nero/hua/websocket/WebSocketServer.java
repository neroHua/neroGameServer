package com.nero.hua.websocket;

import com.alibaba.fastjson.JSON;
import com.nero.hua.model.base.BaseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
@ServerEndpoint("/webSocket/{userId}")
@Slf4j
public class WebSocketServer {

    private static AtomicLong onLineUserCount = new AtomicLong();

    private static Map<String, Session> userSessionMap = new ConcurrentHashMap();

    private static long addSession(String userId, Session session) {
        userSessionMap.put(userId, session);
        if (!userSessionMap.containsKey(userId)) {
            onLineUserCount.incrementAndGet();
        }

        return onLineUserCount.get();
    }

    private static long removeSession(String userId, Session session) {
        if (!userSessionMap.containsKey(userId)) {
            onLineUserCount.decrementAndGet();
        }
        userSessionMap.remove(userId, session);

        return onLineUserCount.get();
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        log.info("user: {} login", userId);
        addSession(userId, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("userId") String userId) {
        log.info("user: {} close", userId);
        removeSession(userId, session);
    }

    @OnError
    public void onError(Session session, @PathParam("userId") String userId, Throwable error) {
        log.info("user: {} error", userId);
        error.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, @PathParam("userId") String userId, String message) {
        log.info("user: {} message: {}", userId, message);
    }

    public void sendMessage(String userId, BaseMessage baseMessage) {
        Session session = userSessionMap.get(userId);

        try {
            session.getBasicRemote().sendText(JSON.toJSONString(baseMessage));
        } catch (IOException e) {
            log.error(JSON.toJSONString(baseMessage), e);
        }
    }

    public void sendMessage(List<String> userIdList, BaseMessage baseMessage) {
        try {
            for (String userId : userIdList) {
                Session session = userSessionMap.get(userId);
                session.getBasicRemote().sendText(JSON.toJSONString(baseMessage));
            }
        } catch (IOException e) {
            log.error(JSON.toJSONString(baseMessage), e);
        }
    }

}
