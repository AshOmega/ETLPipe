package com.etlpipe.model;

import com.etlpipe.component.IComponent;
import com.etlpipe.component.config.PipelineGlobalConfig;
import com.etlpipe.component.config.TemplateConfig;

import java.util.List;
import java.util.function.Function;

public class Stage implements IStage
{
    private String name;
    private int position;
    private IComponent component;
    private Function<Object, Object> function;
    private Object stageOutput = new Object();

    private Stage(){}

    public Stage(String name, IComponent component, Function<Object, Object> function)
    {
        this.name = name;
        this.component = component;
        this.function = function;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public Object getStageOutput()
    {
        return stageOutput;
    }

    public void setStageOutput(Object stageOutput)
    {
        this.stageOutput = stageOutput;
    }

    public IComponent getComponent()
    {
        return component;
    }

    public void setComponent(IComponent component)
    {
        this.component = component;
    }

    public Function<Object, Object> getFunction()
    {
        return function;
    }

    public void setFunction(Function<Object, Object> function)
    {
        this.function = function;
    }


    @Override
    public Object execute(Object previousResponse, TemplateConfig templateConfig, PipelineGlobalConfig pipelineGlobalConfig, List<Stage> stages)
    {
        Object result = null;
        System.out.println("Previous stage value : " + previousResponse);
        System.out.println("Executing Stage : " + this.name);
        Object response = component.execute(previousResponse, pipelineGlobalConfig);

        if(function == null)
        {
            this.setStageOutput(response);
            return response;
        }
        else
        {
            result = function.apply(response);
            this.setStageOutput(result);
            System.out.println("Result of Execution:: " + result);
        }
        return result;
    }
}
