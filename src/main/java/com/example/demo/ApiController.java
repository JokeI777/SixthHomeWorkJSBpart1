package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @CallCounter
    @GetMapping("/first")
    public String firstApi() {
        log.info("First Api");
        return "first";
    }

    @CallCounter
    @PostMapping("/second")
    public String secondApi() {
        log.info("Second Api");
        return "second";
    }
}