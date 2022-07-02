package com.etlpipe.component.impl.rest;

import com.etlpipe.component.IComponent;
import com.etlpipe.component.config.IRestConfig;
import com.etlpipe.component.config.PipelineGlobalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestPost implements IComponent, IRestPost
{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;
    private IRestConfig restConfig;

    private RestPost(){}

    public RestPost(String name, IRestConfig postConfig)
    {
        this.name = name;
        this.restConfig = postConfig;
    }


    @Override
    public Object execute(Object previousResponse, PipelineGlobalConfig pipelineGlobalConfig)
    {
        System.out.println("Previous stage value : " + previousResponse);
        System.out.println("Executing RestPost() : " + this.name);
        System.out.println();

        return null;
    }

    public ResponseEntity<String> executeHttpPost(String url, HttpHeaders headers, Map<String, String> queryParams) throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity entity = new HttpEntity(headers);

        long startTimeMillis = System.currentTimeMillis();
        logger.debug("RestPost::executeHttpPost - Calling API for url={} - startTimeMillis={}", url, startTimeMillis);
        ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            entity,
            String.class,
            queryParams
        );
        long endTimeMillis = System.currentTimeMillis();
        logger.debug("RestPost::executeHttpPost - Received response for url={} - startTimeMillis={}, endTimeMillis={}, durationMillis={}",
            url, startTimeMillis, endTimeMillis, (endTimeMillis - startTimeMillis));
        return response;
    }

    /*public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
    {
        return restTemplateBuilder
            .setConnectTimeout(...)
           .setReadTimeout(...)
           .build();
    }*/
}
