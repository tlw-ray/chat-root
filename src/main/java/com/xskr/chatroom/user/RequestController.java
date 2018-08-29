package com.xskr.chatroom.user;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class RequestController {
    @MessageMapping("/onk-req")
    @SendTo("/topic/onk-master")
    public String req(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        //处理message
        System.out.println(message);
        return message;
    }
}
