package com.singlespark.websocketsse.websocket.handler;


import com.singlespark.websocketsse.util.Pairs;
import com.singlespark.websocketsse.websocket.service.WebSocketServices;
import jakarta.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;


@Component
public class JoyWebSocketHandler implements WebSocketHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(JoyWebSocketHandler.class);

    private final WebSocketServices webSocketServices;

    @Autowired
    JoyWebSocketHandler(final WebSocketServices webSocketServices) {
        this.webSocketServices = webSocketServices;
    }

    @Nonnull
    @Override
    public Mono<Void> handle(final WebSocketSession session) {

        return session.receive()
                      .flatMap(message -> {
                          String payload = message.getPayloadAsText();
                          LOGGER.info("Received message {}", Pairs.pairsOf("payload", payload));

                          if ("reject".equals(payload)) {
                              LOGGER.info("Client rejected the request, closing session");
                              return session.close();
                          }
                          else {
                              String responsePayload = webSocketServices.requestProcessor(payload);
                              LOGGER.info("Sending response {}", Pairs.pairsOf("payload", responsePayload));
                              return session.send(Mono.just(session.textMessage(responsePayload)));
                          }
                      })
                      .doFinally(signalType -> LOGGER.info("WebSocket session {}",
                                  Pairs.pairsOf("sessionId", session.getId(), "signal", signalType)))
                      .then();
    }
}
