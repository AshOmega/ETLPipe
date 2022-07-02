package com.etlpipe.component.config;

import org.springframework.util.MultiValueMap;

public class RestConfigUrlEncoded implements IRestConfig
{
    private String serviceUrl;
    private MultiValueMap<String, String> payloadMap;

    private RestConfigUrlEncoded(){}

    public RestConfigUrlEncoded(String serviceUrl, MultiValueMap<String, String> payloadMap){
        this.serviceUrl = serviceUrl;
        this.payloadMap = payloadMap;
    }

    public String getServiceUrl()
    {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl)
    {
        this.serviceUrl = serviceUrl;
    }

    public MultiValueMap<String, String> getPayloadMap()
    {
        return payloadMap;
    }

    public void setPayloadMap(MultiValueMap<String, String> payloadMap)
    {
        this.payloadMap = payloadMap;
    }
}
