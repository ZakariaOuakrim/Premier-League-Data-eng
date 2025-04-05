package com.zakaria.processor.transformer;

import org.json.JSONArray;
import org.json.JSONObject;

public class LeagueTableTransformer implements TransformerUtils {

    @Override
    public void jsonParser(JSONObject data) {
        JSONArray jsonLeagues = data.getJSONArray("teams");
        JSONObject obj;
        for(int i =0;i<jsonLeagues.length();i++){
            obj = jsonLeagues.getJSONObject(i);
            //convert String values to int : Played, Lost, GoalsFor, Points, GoalDifference, GoalAgainst, Won, Drawn,
            if(obj.has("Played") && obj.get("Played") instanceof String){
                obj.put("Played", Integer.parseInt(obj.getString("Played")));
            }
            if(obj.has("Lost") && obj.get("Lost") instanceof String){
                obj.put("Lost", Integer.parseInt(obj.getString("Lost")));
            }
            if(obj.has("Goals For") && obj.get("Goals For") instanceof String){
                obj.put("Goals For", Integer.parseInt(obj.getString("Goals For")));
            }
            if(obj.has("Points") && obj.get("Points") instanceof String){
                obj.put("Points", Integer.parseInt(obj.getString("Points")));
            }
            if(obj.has("Goal Difference") && obj.get("Goal Difference") instanceof String){
                obj.put("Goal Difference", Integer.parseInt(obj.getString("Goal Difference")));
            }
            if(obj.has("Goal Against") && obj.get("Goal Against") instanceof String){
                obj.put("Goal Against", Integer.parseInt(obj.getString("Goal Against")));
            }
            if(obj.has("Won") && obj.get("Won") instanceof String){
                obj.put("Won", Integer.parseInt(obj.getString("Won")));
            }
            if(obj.has("Drawn") && obj.get("Drawn") instanceof String){
                obj.put("Drawn", Integer.parseInt(obj.getString("Drawn")));
            }


            //create the team position property
            if(obj.has("Team") && obj.get("Team") instanceof String){
                //team name and teamPosition
                String teamName= obj.getString("Team");
                String[] teamNameAndPosition= teamName.split("(?<=^(1?\\d|20))\\s");
                obj.put("Position", Integer.parseInt(teamNameAndPosition[0]));
                obj.put("Team", teamNameAndPosition[1]);
            }
            System.out.println("+++object"+obj);
        }
    }


}
