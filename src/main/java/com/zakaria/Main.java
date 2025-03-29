package com.zakaria;

import com.zakaria.scraper.MatchScheduleScraper;
import com.zakaria.scraper.Scraper;

public class Main {
    public static void main(String[] args) {
        Scraper scraper = new MatchScheduleScraper();
        scraper.scrapDataFromBBC();
    }
}
