package com.etlpipe.service.processors;

import com.etlpipe.component.config.PipelineGlobalConfig;
import com.etlpipe.component.config.TemplateConfig;
import com.etlpipe.model.Stage;

import java.util.List;

public class StageProcessor
{
    Stage stage;
    TemplateConfig templateConfig;
    PipelineGlobalConfig pipelineGlobalConfig;
    List<Stage> stages;

    private StageProcessor(){}

    public StageProcessor(Stage stage, TemplateConfig templateConfig, PipelineGlobalConfig pipelineGlobalConfig, List<Stage> stages)
    {
        this.stage = stage;
        this.templateConfig = templateConfig;
        this.pipelineGlobalConfig = pipelineGlobalConfig;
        this.stages = stages;
    }

    public Object process(Object previousResponse){
        Object result = stage.execute(previousResponse, templateConfig, pipelineGlobalConfig, stages);
        return result;
    }
}
