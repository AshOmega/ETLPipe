package com.etlpipe.component;

import com.etlpipe.component.config.PipelineGlobalConfig;

public interface IComponent
{
    Object execute(Object previousResponse, PipelineGlobalConfig pipelineGlobalConfig);
}
