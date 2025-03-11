package com.zakaria;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

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
            System.out.println("Headers:");
            for (Element header : headers) {
                System.out.print(header.text() + "\t");
            }

            // Extract table rows
            Elements rows = table.select("tbody tr");
            for (Element row : rows) {
                Elements columns = row.select("td");
                for (Element column : columns) {
                    System.out.print(column.text() + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
