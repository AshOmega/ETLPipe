package com.etlpipe.service.processors;

import com.etlpipe.component.IComponent;

public class StageProcessor
{
    IComponent stage;
    private StageProcessor(){}

    public StageProcessor(IComponent stage){
        this.stage = stage;
    }

    public Object process(Object previousResponse){
        Object result = stage.execute(previousResponse);
        return result;
    }
}
