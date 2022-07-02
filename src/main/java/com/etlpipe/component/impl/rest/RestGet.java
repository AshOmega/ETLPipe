package com.etlpipe.component.impl.rest;

import com.etlpipe.component.IComponent;
import com.etlpipe.component.config.IRestConfig;
import com.etlpipe.component.config.PipelineGlobalConfig;
import com.etlpipe.component.config.RestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class RestGet implements IComponent, IRestGet
{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;
    private IRestConfig restConfig;

    private RestGet(){}

    public RestGet(String name, IRestConfig restConfig)
    {
        this.name = name;
        this.restConfig = restConfig;
    }

    @Override
    public Object execute(Object previousResponse, PipelineGlobalConfig pipelineGlobalConfig)
    {
        System.out.println("Previous stage value : " + previousResponse);
        System.out.println("Executing RestPost() : " + this.name);
        System.out.println();
        RestConfig config = (RestConfig)restConfig;
        String response = getRequest(config.getServiceUrl(), config.getHeaders(), config.getQueryParams(), pipelineGlobalConfig);

        return response;
    }

    public String getRequest(String url, HttpHeaders headers, Map<String, String> queryParams, PipelineGlobalConfig pipelineGlobalConfig)
    {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity entity = new HttpEntity(headers);

        if(url.contains("$")){
            int dollarPos = url.indexOf("$");
            int hashPos = url.indexOf("#");
            String subString = url.substring(dollarPos + 1, hashPos);
            url = url.substring(0, dollarPos);
            url += pipelineGlobalConfig.getConfig().get(subString);
        }

        if(headers.get("Authorization") != null){
            String auth = headers.get("Authorization").get(0);
            if(auth.contains("$")){
                int dollarPos = auth.indexOf("$");
                int hashPos = auth.indexOf("#");
                String subString = auth.substring(dollarPos + 1, hashPos);
                auth = "Bearer " + pipelineGlobalConfig.getConfig().get(subString);
            }
            headers.set("Authorization", auth);
        }

        long startTimeMillis = System.currentTimeMillis();
        logger.debug("RestGet::getRequest - url={}, startTimeMillis={}", url, startTimeMillis);
        ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            String.class,
            queryParams
        );
        long endTimeMillis = System.currentTimeMillis();
        logger.debug("RestGet::getRequest response - url={}, startTimeMillis={}, endTimeMillis={}, durationMillis={}",
            url, startTimeMillis, endTimeMillis, (endTimeMillis - startTimeMillis));
        return response.getBody();
    }
}
