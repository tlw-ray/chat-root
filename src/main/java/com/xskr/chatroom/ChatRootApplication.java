package com.xskr.chatroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//所有人都向ADMIN发话，ADMIN向所有人广播

@SpringBootApplication
public class ChatRootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatRootApplication.class, args);
    }
}
