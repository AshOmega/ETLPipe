package com.etlpipe.service.processors;

import com.etlpipe.component.IComponent;

import java.util.List;

public class PipelineProcessor
{
    List<IComponent> stages;
    private PipelineProcessor(){}

    public PipelineProcessor(List<IComponent> stages)
    {
        this.stages = stages;
    }

    public Object triggerPipeline()
    {
        Object response = null;

        for (IComponent stage : stages)
        {
            StageProcessor stageProcessor = new StageProcessor(stage);
            response = stageProcessor.process(response);
        }

        return response;
    }
}
