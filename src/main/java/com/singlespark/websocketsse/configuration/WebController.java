package com.singlespark.websocketsse.configuration;


import com.singlespark.websocketsse.sse.handler.ServerSentEventRequestController;
import com.singlespark.websocketsse.util.Pairs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;


@Controller
@RequestMapping("/")
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerSentEventRequestController.class);

    @GetMapping(value = { "/index", "/index/{sessionId}" })
    public String index(final Model model, @PathVariable(required = false) final Long sessionId) {
        Long generateSessionId = sessionId == null ? generateSessionId() : sessionId;
        LOGGER.info("Enter WebPage View {}", Pairs.pairsOf("sessionId", generateSessionId));
        model.addAttribute("sessionId", generateSessionId);
        return "index";
    }

    @GetMapping("/status-check")
    public String poll(final Model model) {
        return "poll";
    }


    private Long generateSessionId() {
        return Instant.now().toEpochMilli();
    }

}
