package design_problems.ass.customer_satisfaction.practice;

import design_problems.ass.customer_satisfaction.Agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingService {
    Map<String, Agent> agentMap = new HashMap<>();

    public final int MIN_RATING , MAX_RATING;

    RatingService(int min,int max){
        MIN_RATING = min;
        MAX_RATING = max;
    }

    void giveRating(String agentName, int rating){
        if(rating < MIN_RATING || rating > MAX_RATING){
            throw  new IllegalArgumentException(" Invalid Rating");
        }
        agentMap.computeIfAbsent(agentName,k->new Agent(agentName)).addRating(rating);
    }

    List<Agent> getRatings(){
        List<Agent> agentList = new ArrayList<>();
        agentList.addAll(agentMap.values());

        agentList.sort((a,b)->{
            int comp = Double.compare(b.getAverageRating(), a.getAverageRating());
            if(comp == 0){
                return a.name.compareTo(b.name);
            }


            return comp;
        });


      return agentList;
    }

}
