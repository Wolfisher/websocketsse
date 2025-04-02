package com.singlespark.websocketsse.sse.handler;


import com.singlespark.websocketsse.sse.model.RequestType;
import com.singlespark.websocketsse.sse.model.SSEMessage;
import com.singlespark.websocketsse.util.Pairs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

import static com.singlespark.websocketsse.NexusConstants.ROOT_PATH;



@RestController
@RequestMapping(ROOT_PATH)
public class ServerSentEventRequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerSentEventRequestController.class);

    private final ConcurrentHashMap<Long, Sinks.Many<ServerSentEvent<SSEMessage>>> clients = new ConcurrentHashMap<>();

    @GetMapping("/session/status/{sessionId}")
    public Flux<ServerSentEvent<SSEMessage>> streamEvents(@PathVariable final Long sessionId) {
        Sinks.Many<ServerSentEvent<SSEMessage>> sink = Sinks.many().multicast().onBackpressureBuffer();
        clients.put(sessionId, sink);

        Flux<ServerSentEvent<SSEMessage>> heartbeatFlux = Flux.interval(Duration.ofSeconds(1))
                                                              .map(tick -> ServerSentEvent.builder(SSEMessage.builder().type(RequestType.HEARTBEAT).build())
                                                                                          .comment("heartbeat").build());

        return Flux.merge(sink.asFlux(), heartbeatFlux)
                   .doOnCancel(() -> handleClientDisconnect(sessionId))
                   .doOnTerminate(() -> handleClientDisconnect(sessionId));
    }

    @PostMapping("/session/progress/{sessionId}")
    public Mono<ResponseEntity<SSEMessage>> postMessage(@PathVariable final Long sessionId, @RequestBody final SSEMessage message) {
        Sinks.Many<ServerSentEvent<SSEMessage>> clientSink = clients.get(sessionId);
        LOGGER.info("Message Received{}", Pairs.pairsOf("msg", message));
        if (clientSink != null) {
            if (message.isEnd()) {
                LOGGER.info("Enter into NORMAL connection termination");
                SSEMessage disconnectMessage = SSEMessage.builder()
                                                         .type(RequestType.DISCONNECTED)
                                                         .message("Server ended the session")
                                                         .build();

                clientSink.tryEmitNext(ServerSentEvent.builder(disconnectMessage).build());
                clientSink.tryEmitComplete(); // Mark the sink as complete, signaling the end of the stream
                clients.remove(sessionId); // Remove the session after marking complete
                return Mono.just(ResponseEntity.ok(SSEMessage
                            .builder().type(RequestType.DISCONNECTED)
                            .message("Disconnect signal sent to client: " + sessionId).build()));
            }
            clientSink.tryEmitNext(ServerSentEvent.builder(message).build());
            return Mono.just(ResponseEntity.ok(SSEMessage
                        .builder().type(RequestType.MESSAGE)
                        .message("Message sent to client: " + sessionId).build()));
        }
        else {
            return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                           .body(SSEMessage.builder().type(RequestType.DISCONNECTED)
                                                           .message("No active SSE connection for client: " + sessionId).build()));
        }
    }

    @GetMapping("/session/connection-status/{sessionId}")
    public ResponseEntity<SSEMessage> getConnectionStatus(@PathVariable final Long sessionId) {
        String status = clients.containsKey(sessionId) ? "ACTIVE" : "INACTIVE";
        String response = "Session %d is %s at %s".formatted(sessionId, status, LocalDateTime.now().toString());
        return ResponseEntity.ok(SSEMessage.builder().type(RequestType.HEARTBEAT).message(response).build());
    }


    private void handleClientDisconnect(final Long sessionId) {
        clients.remove(sessionId);
        LOGGER.info("Client disconnected, sessionId={}", sessionId);
    }


}
