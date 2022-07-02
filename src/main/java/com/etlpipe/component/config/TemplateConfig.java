package com.etlpipe.component.config;

import java.util.HashMap;
import java.util.Map;

public class TemplateConfig
{
    private String name;
    private Map<String, Object> config = new HashMap<>();

    private TemplateConfig(){}

    public TemplateConfig(String name, Map<String, Object> config)
    {
        this.name = name;
        this.config = config;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Map<String, Object> getConfig()
    {
        return config;
    }

    public void setConfig(Map<String, Object> config)
    {
        this.config = config;
    }
}
