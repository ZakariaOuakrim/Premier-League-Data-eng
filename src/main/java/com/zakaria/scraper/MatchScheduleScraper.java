package com.zakaria.scraper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;


public class MatchScheduleScraper implements Scraper{

    @Override
    public JSONObject scrapDataFromBBC() {
        try{
            //connect to the website
            Document doc = Jsoup.connect("https://www.bbc.com/sport/football/premier-league/scores-fixtures").get();

            //div of the matches
            Elements divOfMatches = doc.select("div.ssrcss-1jkg1a7-HeaderWrapper.e4zdov50");

            if(divOfMatches==null){
                System.out.println("No Match div found on the page.");
                return null;
            }

            JSONObject jsonObject = new JSONObject();
            int index =0;
            for(Element match : divOfMatches){
                //dates of the match
                //Elements dateMatch=match.select("h2.ssrcss-12l0oeb-GroupHeader.ejnn8gi5");
                //jsonObject.put("date", LocalDate.now());

                //teams & score of the match
                Elements teamsPlaying=match.select("span.visually-hidden.ssrcss-1f39n02-VisuallyHidden.e16en2lz0");

                JSONArray teams = new JSONArray();
                index++;
                for(Element team : teamsPlaying){
                    //get the first element
                    Element teamNameAndScore=team.select("span.visually-hidden.ssrcss-1f39n02-VisuallyHidden.e16en2lz0").first();

                    //here I am checking if the teamNameAndScore is not null and contains a comma because we find it in the team name and score
                    if(teamNameAndScore!=null && teamNameAndScore.text().contains("versus")){
                        teams.put(teamNameAndScore.text());
                    }

                }
                jsonObject.put("teams",teams);

            }
            //System.out.println(matches.toString(4)); // Pretty print
            return jsonObject;
        }catch (Exception e){
            System.out.println("Error while scrapping Match Schedule data from BBC "+e.getMessage());
        }
        return null;
    }
}
