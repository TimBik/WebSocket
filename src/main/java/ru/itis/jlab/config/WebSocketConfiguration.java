package ru.itis.jlab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import ru.itis.jlab.handler.AuthHandshakeHandler;
import ru.itis.jlab.handler.WebSocketMessagesHandler;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketConfigurer, WebSocketMessageBrokerConfigurer {

    @Autowired
    private WebSocketMessagesHandler handler;

    @Autowired
    private AuthHandshakeHandler authHandshakeHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(handler, "/chat")
                .setHandshakeHandler(authHandshakeHandler).withSockJS();
    }

    @Value("${sockjs.websocket.enabled}")
    private boolean webSocketEnabled;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat")
                .withSockJS()
                .setInterceptors(new HttpSessionHandshakeInterceptor())
                .setWebSocketEnabled(webSocketEnabled);
    }
}