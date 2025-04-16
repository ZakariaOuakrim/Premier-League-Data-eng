package com.zakaria.processor.pipeline;

import com.zakaria.processor.cleaner.DataCleaner;
import com.zakaria.processor.cleaner.MatchDataCleaner;
import com.zakaria.processor.transformer.MatchDataTransformer;
import com.zakaria.processor.transformer.TransformerUtils;
import org.json.JSONObject;

public class MatchProcessingPipeline implements ProcessingPipeline{
    @Override
    public void process(JSONObject jsonObject) {
        DataCleaner dataCleaner = new MatchDataCleaner();
        dataCleaner.cleanData(jsonObject);

        //transform data
        TransformerUtils transformerUtils = new MatchDataTransformer();
        transformerUtils.jsonParser(jsonObject);


    }
}
