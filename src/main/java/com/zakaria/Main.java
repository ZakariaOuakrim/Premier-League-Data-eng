package com.zakaria;

import com.zakaria.processor.pipeline.LeagueTableDataPipeline;
import com.zakaria.processor.pipeline.MatchProcessingPipeline;
import com.zakaria.processor.pipeline.ProcessingPipeline;
import com.zakaria.scraper.LeagueTableScraper;
import com.zakaria.scraper.MatchScheduleScraper;
import com.zakaria.scraper.TopScorersPlayersScraper;
import com.zakaria.scraper.Scraper;

public class Main {
    public static void main(String[] args) {
        ProcessingPipeline processingPipeline = new MatchProcessingPipeline();
        Scraper scraper = new MatchScheduleScraper();
        processingPipeline.process(scraper.scrapDataFromBBC());
    }
}
