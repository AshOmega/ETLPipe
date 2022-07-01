package com.etlpipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HealthCheck
{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/healthcheck")
    public void healthCheck(HttpServletRequest request, HttpServletResponse response){
        logger.debug("HealthCheck::healthCheck - health check ok");
        response.setStatus(HttpStatus.ACCEPTED.value());
    }
}
