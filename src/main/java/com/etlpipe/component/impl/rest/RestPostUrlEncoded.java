package com.etlpipe.component.impl.rest;

import com.etlpipe.component.IComponent;
import com.etlpipe.component.config.IRestConfig;
import com.etlpipe.component.config.RestConfigUrlEncoded;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestPostUrlEncoded implements IComponent, IRestPost
{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;
    private IRestConfig restConfig;

    private RestPostUrlEncoded(){}

    public RestPostUrlEncoded(String name, IRestConfig postConfig)
    {
        this.name = name;
        this.restConfig = postConfig;
    }


    @Override
    public Object execute(Object previousResponse)
    {
        System.out.println("Previous stage value : " + previousResponse);
        System.out.println("Executing RestPost() : " + this.name);
        System.out.println();

        RestConfigUrlEncoded configUrlEncoded = (RestConfigUrlEncoded)restConfig;
        JSONObject jsonObject = postRequest(configUrlEncoded.getServiceUrl(), configUrlEncoded.getPayloadMap());
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    public JSONObject postRequest(String url, MultiValueMap<String, String> payloadMap) throws JSONException
    {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(payloadMap, headers);

        long startTimeMillis = System.currentTimeMillis();
        logger.debug("RestPostUrlEncoded::postRequest - url={}, startTimeMillis={}", url, startTimeMillis);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        long endTimeMillis = System.currentTimeMillis();
        logger.debug("RestPostUrlEncoded::postRequest response - url={}, startTimeMillis={}, endTimeMillis={}, durationMillis={}",
            url, startTimeMillis, endTimeMillis, (endTimeMillis - startTimeMillis));

        JSONObject responseObj = null;
        if(response.hasBody())
        {
            responseObj = new JSONObject(response.getBody());
        }
        return responseObj;
    }

    /*public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
    {
        return restTemplateBuilder
            .setConnectTimeout(...)
           .setReadTimeout(...)
           .build();
    }*/
}
