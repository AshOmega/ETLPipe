package com.etlpipe.component.config;

import com.etlpipe.component.common.HttpRetrySpec;

import java.util.Map;

public class RestConfig implements IRestConfig
{
    private String serviceUrl;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private HttpRetrySpec httpRetrySpec;

    private RestConfig(){}

    public RestConfig(String serviceUrl, Map<String, String> headers, Map<String, String> queryParams, HttpRetrySpec httpRetrySpec)
    {
        this.serviceUrl = serviceUrl;
        this.headers = headers;
        this.queryParams = queryParams;
        this.httpRetrySpec = httpRetrySpec;
    }

    public String getServiceUrl()
    {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl)
    {
        this.serviceUrl = serviceUrl;
    }

    public Map<String, String> getHeaders()
    {
        return headers;
    }

    public void setHeaders(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public Map<String, String> getQueryParams()
    {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams)
    {
        this.queryParams = queryParams;
    }

    public HttpRetrySpec getHttpRetrySpec()
    {
        return httpRetrySpec;
    }

    public void setHttpRetrySpec(HttpRetrySpec httpRetrySpec)
    {
        this.httpRetrySpec = httpRetrySpec;
    }
}
