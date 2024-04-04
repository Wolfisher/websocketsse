package com.singlespark.websocketsse;


import com.singlespark.websocketsse.util.Pairs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class WebSocketSSEApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketSSEApplication.class);
    private static final String ERROR = "ERROR";


    public static void main(final String... args) {
        final SpringApplication app = new SpringApplication(WebSocketSSEApplication.class);

        try {
            app.run(args);
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(final ApplicationReadyEvent event) {
        ReactiveWebServerApplicationContext ctx = (ReactiveWebServerApplicationContext)event.getApplicationContext();
        int port = ctx.getWebServer().getPort();
        LOGGER.info("Application Startup INFO {}",
                    Pairs.pairsOf("jdkVersion", System.getProperty("java.home"), "portNumber", port));
    }

}
