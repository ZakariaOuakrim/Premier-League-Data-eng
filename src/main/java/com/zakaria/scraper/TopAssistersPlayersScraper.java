package com.zakaria.scraper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TopAssistersPlayersScraper implements Scraper {
    @Override
    public JSONObject scrapDataFromBBC() {
        try{
            //connect to the website
            Document doc = Jsoup.connect("https://www.bbc.com/sport/football/premier-league/top-scorers#TopAssists").get();
            Element table = doc.select("table").first();
            if (table == null) {
                System.out.println("No table found on the page.");
                return null;
            }
            //extract table headers
            Elements headers = table.select("thead th");
            List<String> headerList=new ArrayList<>();
            for (Element header : headers) {
                String tableHeader=header.text();
                headerList.add(tableHeader);
                System.out.print(header.text() + "\t");
            }

            JSONArray jsonArray = new JSONArray();
            Elements rows = table.select("tbody tr");
            for (Element row : rows) {
                Elements columns = row.select("td");
                JSONObject teamObject = new JSONObject();

                for(int i=0;i<columns.size() && i < headerList.size();i++){
                    teamObject.put(headerList.get(i),columns.get(i).text());
                }
                jsonArray.put(teamObject);

            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("players", jsonArray);

            System.out.println(jsonObject.toString(4));
            return jsonObject;

        }catch (Exception e){
            System.out.println("Error in PlayerPerformanceScraper: " + e.getMessage());
        }
        return null;
    }
}
