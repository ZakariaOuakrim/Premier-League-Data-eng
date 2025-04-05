package com.zakaria;

import com.zakaria.processor.pipeline.LeagueTableDataPipeline;
import com.zakaria.processor.pipeline.ProcessingPipeline;
import com.zakaria.scraper.LeagueTableScraper;
import com.zakaria.scraper.TopScorersPlayersScraper;
import com.zakaria.scraper.Scraper;

public class Main {
    public static void main(String[] args) {
        ProcessingPipeline processingPipeline = new LeagueTableDataPipeline();
        Scraper scraper = new LeagueTableScraper();
        processingPipeline.process(scraper.scrapDataFromBBC());
    }
}
