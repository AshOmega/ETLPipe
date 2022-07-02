package com.etlpipe.component.common;

public class HttpRetrySpec
{
    private int readTimeout;
    private int connectionTimeout;
    private int maxRetryAttempts;
    private int retryInterval;

    private HttpRetrySpec(){}

    public HttpRetrySpec(int readTimeout, int connectionTimeout, int maxRetryAttempts, int retryInterval)
    {
        this.readTimeout = readTimeout;
        this.connectionTimeout = connectionTimeout;
        this.maxRetryAttempts = maxRetryAttempts;
        this.retryInterval = retryInterval;
    }

    public int getReadTimeout()
    {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
    }

    public int getConnectionTimeout()
    {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout)
    {
        this.connectionTimeout = connectionTimeout;
    }

    public int getMaxRetryAttempts()
    {
        return maxRetryAttempts;
    }

    public void setMaxRetryAttempts(int maxRetryAttempts)
    {
        this.maxRetryAttempts = maxRetryAttempts;
    }

    public int getRetryInterval()
    {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval)
    {
        this.retryInterval = retryInterval;
    }
}
