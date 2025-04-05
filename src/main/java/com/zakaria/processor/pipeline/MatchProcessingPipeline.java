package com.zakaria.processor.pipeline;

import com.zakaria.processor.cleaner.DataCleaner;
import com.zakaria.processor.cleaner.MatchDataCleaner;
import org.json.JSONObject;

public class MatchProcessingPipeline implements ProcessingPipeline{
    @Override
    public void process(JSONObject jsonObject) {
        DataCleaner dataCleaner = new MatchDataCleaner();
        dataCleaner.cleanData(jsonObject);

    }
}
