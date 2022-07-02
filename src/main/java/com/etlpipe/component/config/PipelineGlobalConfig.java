package com.etlpipe.component.config;

import java.util.HashMap;
import java.util.Map;

public class PipelineGlobalConfig
{
    private Map<String, Object> config = new HashMap<>();

    public Map<String, Object> getConfig()
    {
        return config;
    }

    public void setConfig(Map<String, Object> config)
    {
        this.config = config;
    }

    public void addToGlobalConfig(String key, Object value){
        this.config.put(key, value);
    }
}
