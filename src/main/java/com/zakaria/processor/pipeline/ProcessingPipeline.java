package com.zakaria.processor.pipeline;

import org.json.JSONObject;

public interface ProcessingPipeline {
    public void process(JSONObject jsonObject);
}
