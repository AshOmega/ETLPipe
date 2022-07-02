package com.etlpipe.service;

import com.etlpipe.component.IComponent;

import java.util.ArrayList;
import java.util.List;

public class Pipeline
{
    static Pipeline pipeline = new Pipeline();
    List<IComponent> stages = new ArrayList<>();

    private Pipeline(){}

    public static Pipeline getInstance(){
        return pipeline;
    }

    public Pipeline add(IComponent component){
        this.stages.add(component);
        return pipeline;
    }

    public List<IComponent> getPipeline(){
        return this.stages;
    }
}
