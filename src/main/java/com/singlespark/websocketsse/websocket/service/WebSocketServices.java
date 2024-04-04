package com.singlespark.websocketsse.websocket.service;


import org.springframework.stereotype.Service;


@Service
public class WebSocketServices {
    public String requestProcessor(final String input) {
        return switch (input) {
            case "init" -> "initialized successfully";
            case "update" -> "updated successfully";
            case "send device info" -> "Device Info Received";
            default -> "Echo message from Client: " + input;
        };
    }
}
