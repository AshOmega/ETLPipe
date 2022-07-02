package com.etlpipe.model;

import java.util.ArrayList;
import java.util.List;

public class Pipeline
{
    private static Pipeline pipeline = new Pipeline();
    private List<Stage> stages = new ArrayList<>();
    private int stagePosition = 0;

    private Pipeline(){}

    public static Pipeline getInstance(){
        return pipeline;
    }

    public Pipeline add(Stage stage){
        stage.setPosition(stagePosition++);
        this.stages.add(stage);
        return pipeline;
    }

    public List<Stage> getPipeline(){
        return this.stages;
    }
}
