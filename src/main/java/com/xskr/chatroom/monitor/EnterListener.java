package com.xskr.chatroom.monitor;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

// 玩家进入房间

@Component
public class EnterListener {

    @EventListener
    public void event(SessionConnectEvent event) {
        System.out.println(event + " WebSocketConnect 已连接...");
    }

}
