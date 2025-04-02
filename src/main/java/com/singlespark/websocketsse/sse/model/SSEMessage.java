package com.singlespark.websocketsse.sse.model;


import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SSEMessage {
    RequestType type;
    String message;

    public boolean isEnd() {
        return this.getType().equals(RequestType.DISCONNECTED)
                    || this.getType().equals(RequestType.TERMINATED);
    }

}
