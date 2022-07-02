package com.etlpipe.template;

public interface IBaseTemplate
{
    void initialize();
    void createPipeline();
    void executePipeline();
}
