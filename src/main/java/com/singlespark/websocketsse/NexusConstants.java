package com.singlespark.websocketsse;


public interface NexusConstants {

    /**
     * The version of the REST APIs
     */
    String API_VERSION = "v1";

    /**
     * The root of all REST API URLs
     */
    String API_PREFIX = "/api/" + API_VERSION;


    String ROOT_PATH = API_PREFIX + "/serversentevent";
    String NEXUS_WEBSOCKET = "/nexus/websocket";
    String SSE_DISCONNECT = "Disconnected";

}
