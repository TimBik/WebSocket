package ru.itis.jlab.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.jlab.dto.MessageDto;

import java.util.HashMap;
import java.util.Map;

@Component
@EnableWebSocket
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    private static final Map<String, Map<String, WebSocketSession>> sessions = new HashMap<>();

    @Autowired
    ObjectMapper objectMapper;



    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String messageText = (String) message.getPayload();
        MessageDto messageFromJson = objectMapper.readValue(messageText, MessageDto.class);

        if (!sessions.containsKey(messageFromJson.getRoom())) {
            sessions.put(messageFromJson.getRoom(), new HashMap<>());
        }
        Map<String, WebSocketSession> sessionsRoom = sessions.get(messageFromJson.getRoom());
        if (!sessionsRoom.containsKey(messageFromJson.getPageId())) {
            sessionsRoom.put(messageFromJson.getPageId(), session);
        }

        for (WebSocketSession currentSession : sessionsRoom.values()) {
            currentSession.sendMessage(message);
        }
    }
}