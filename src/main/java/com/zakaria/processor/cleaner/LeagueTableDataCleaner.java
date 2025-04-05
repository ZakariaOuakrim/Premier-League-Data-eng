package com.zakaria.processor.cleaner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class LeagueTableDataCleaner implements DataCleaner{
    @Override
    public void cleanData(JSONObject data) {
        //iterate over the json object and clean the data
        JSONArray jsonLeagues = data.getJSONArray("teams");
        for(int i =0;i<jsonLeagues.length();i++){
            JSONObject obj = jsonLeagues.getJSONObject(i);

        }
    }
}
