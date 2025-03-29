package com.zakaria;

import com.zakaria.scraper.TopScorersPlayersScraper;
import com.zakaria.scraper.Scraper;

public class Main {
    public static void main(String[] args) {
        Scraper scraper = new TopScorersPlayersScraper();
        scraper.scrapDataFromBBC();
    }
}
