package com.zakaria.processor.pipeline;

import com.zakaria.processor.cleaner.DataCleaner;
import com.zakaria.processor.cleaner.LeagueTableDataCleaner;
import com.zakaria.processor.transformer.LeagueTableTransformer;
import com.zakaria.processor.transformer.TransformerUtils;
import org.json.JSONObject;

public class LeagueTableDataPipeline implements ProcessingPipeline {

    @Override
    public void process(JSONObject jsonObject) {
        DataCleaner dataCleaner = new LeagueTableDataCleaner();
        dataCleaner.cleanData(jsonObject);

        //transform data
        TransformerUtils transformerUtils = new LeagueTableTransformer();
        transformerUtils.jsonParser(jsonObject);


    }
}
