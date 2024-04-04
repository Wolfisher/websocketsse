package com.singlespark.websocketsse.sse.model;


import lombok.ToString;


@ToString
public enum RequestType {
    DISCONNECTED,
    TERMINATED,
    HEARTBEAT,
    MESSAGE
}
