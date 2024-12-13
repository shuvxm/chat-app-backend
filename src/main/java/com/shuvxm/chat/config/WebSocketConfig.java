package com.shuvxm.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // message broker is intermadatory chiz hoti hai jo msg ko server pe rout krti hai
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
//        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
        config.enableSimpleBroker("/topic");
        // /topic/messages

        config.setApplicationDestinationPrefixes("/app");
        //  /app/chat
        // server-side: @MessagingMapping("/chat")

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);

        registry.addEndpoint("/chat")  // connection establishment
                .setAllowedOrigins("*")
                .withSockJS();

        //  /chat endpoint  par connection establish hoga
    }
}
