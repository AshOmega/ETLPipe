package com.etlpipe.template.microsoftteams;

import com.etlpipe.aop.Included;
import com.etlpipe.component.impl.rest.RestPost;
import com.etlpipe.template.IBaseTemplate;

@Included(values = {RestPost.class})
public class MicrosoftTeamsTemplate implements IBaseTemplate
{
    private RestPost restPost;
    private String name;

    @Override
    public void initialize()
    {

    }

    @Override
    public void createPipeline()
    {

    }

    @Override
    public void executePipeline()
    {

    }
}
