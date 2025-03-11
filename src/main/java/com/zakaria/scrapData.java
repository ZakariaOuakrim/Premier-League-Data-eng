package com.zakaria;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class scrapData {
    public static void main(String args[]) {
        try {
            // Connect to the website
            Document doc = Jsoup.connect("https://www.bbc.com/sport/football/premier-league/table").get();

            // Select the table
            Element table = doc.select("table").first();
            if (table == null) {
                System.out.println("No table found on the page.");
                return;
            }
            // Extract table headers
            Elements headers = table.select("thead th");
            List<String> headerList=new ArrayList<>();
            System.out.println("Headers:");
            for (Element header : headers) {
                String tableHeader=header.text();
                headerList.add(tableHeader);
                System.out.print(header.text() + "\t");
            }

            JSONArray jsonArray = new JSONArray();

            // Extract table rows
            Elements rows = table.select("tbody tr");
            for (Element row : rows) {
                Elements columns = row.select("td");
                JSONObject teamObject = new JSONObject();

                for(int i=0;i<columns.size() && i < headerList.size();i++){
                    teamObject.put(headerList.get(i),columns.get(i).text());
                }

                jsonArray.put(teamObject);

                for (Element column : columns) {
                    System.out.print(column.text() + "\t");
                }
                System.out.println();
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("teams", jsonArray);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
