package com.etlpipe.model;

import com.etlpipe.component.config.PipelineGlobalConfig;
import com.etlpipe.component.config.TemplateConfig;

import java.util.List;

public interface IStage
{
    Object execute(Object previousResponse, TemplateConfig templateConfig, PipelineGlobalConfig pipelineGlobalConfig, List<Stage> stages);
}
