package com.xskr.chatroom.monitor;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

// 玩家登录入系统

@Component
public class LoginListener {

    @EventListener
    public void event(AuthenticationSuccessEvent event) {
        System.out.println(event.getAuthentication().getName() + " 来了...");
    }

}
