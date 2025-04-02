package com.singlespark.websocketsse.configuration;


import com.singlespark.websocketsse.websocket.handler.JoyWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static com.singlespark.websocketsse.NexusConstants.NEXUS_WEBSOCKET;


@Configuration
public class WebSocketConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketConfig.class);

    @Bean
    public HandlerMapping webSocketMapping(final JoyWebSocketHandler joyWebSocketHandler) {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put(NEXUS_WEBSOCKET, new LoggingWebSocketHandlerDecorator(joyWebSocketHandler));

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(map);
        mapping.setOrder(1);
        return mapping;
    }

    private record LoggingWebSocketHandlerDecorator(WebSocketHandler delegate) implements WebSocketHandler {

        @Override
        public Mono<Void> handle(final WebSocketSession session) {
            LOGGER.info("New WebSocket connection: {}", session.getId());
            return delegate.handle(session);
        }
    }

}
