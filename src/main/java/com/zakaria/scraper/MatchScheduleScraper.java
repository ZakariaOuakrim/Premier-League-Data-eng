package com.zakaria.scraper;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MatchScheduleScraper implements Scraper{

    @Override
    public JSONObject scrapDataFromBBC() {
        try{
            System.out.println("Scrapping from BBC");
            //connect to the website
            Document doc = Jsoup.connect("https://www.bbc.com/sport/football/premier-league/scores-fixtures").get();

            Elements divOfMatches = doc.select("div.ssrcss-1jkg1a7-HeaderWrapper.e4zdov50");

            if(divOfMatches==null){
                System.out.println("No Match div found on the page.");
                return null;
            }

            for(Element match : divOfMatches){
                //dates of the match
                Elements dateMatch=match.select("h2.ssrcss-12l0oeb-GroupHeader.ejnn8gi5");
                System.out.println("Date match : "+dateMatch.text());

                //teams & score of the match
                Elements teamsPlaying=match.select("span.visually-hidden.ssrcss-1f39n02-VisuallyHidden.e16en2lz0");
                for(Element team : teamsPlaying){
                    System.out.println("Teams playing : "+team.text());
                }


            }




        }catch (Exception e){}
        return null;
    }
}
