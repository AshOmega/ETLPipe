package com.etlpipe.service.processors;

import com.etlpipe.component.config.PipelineGlobalConfig;
import com.etlpipe.component.config.TemplateConfig;
import com.etlpipe.model.Stage;

import java.util.List;

public class PipelineProcessor
{
    List<Stage> stages;
    TemplateConfig templateConfig;
    PipelineGlobalConfig pipelineGlobalConfig;

    private PipelineProcessor(){}

    public PipelineProcessor(List<Stage> stages, TemplateConfig templateConfig, PipelineGlobalConfig pipelineGlobalConfig)
    {
        this.stages = stages;
        this.templateConfig = templateConfig;
        this.pipelineGlobalConfig = pipelineGlobalConfig;
    }

    public PipelineProcessor(List<Stage> stages, TemplateConfig templateConfig)
    {
        this.stages = stages;
        this.templateConfig = templateConfig;
    }

    public Object triggerPipeline()
    {
        Object response = null;

        for (Stage stage : stages)
        {
            StageProcessor stageProcessor = new StageProcessor(stage, templateConfig, pipelineGlobalConfig, stages);
            response = stageProcessor.process(response);
        }

        return response;
    }
}
