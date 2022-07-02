package com.etlpipe.component.transformer;

import com.etlpipe.component.IComponent;
import com.etlpipe.component.config.PipelineGlobalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mapper implements IComponent
{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;

    private Mapper() {}

    public Mapper(String name)
    {
        this.name = name;
    }

    @Override
    public Object execute(Object previousResponse, PipelineGlobalConfig pipelineGlobalConfig)
    {
        return null;
    }
}
