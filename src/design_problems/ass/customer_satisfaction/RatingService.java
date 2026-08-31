package design_problems.ass.customer_satisfaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingService {
    private final int minRating;
    private final int maxRating;
    private final TieBreaker tieBreaker;

    public enum TieBreaker {
        TOTAL_SCORE, // prefer higher total sum of ratings
        MEDIAN,      // prefer higher median rating
        COUNT,       // prefer more ratings
        NAME         // alphabetical ascending
    }

    RatingService(int minRating,int maxRating,TieBreaker tieBreaker){
        this.minRating = minRating;
        this.maxRating = maxRating;
        this.tieBreaker = tieBreaker;
    }

    private final Map<String, Agent> agentMap = new HashMap<>();

    public void giveRating(String agentName, int rating) {
        if (rating < minRating || rating > maxRating) {
            throw new IllegalArgumentException("Rating must be between " + minRating + " and " + maxRating);
        }
        Agent agent = agentMap.computeIfAbsent(agentName, Agent::new);
        agent.addRating(rating);
    }

    public List<Agent> getRatings() {

        List<Agent> agents = new ArrayList<>(agentMap.values());
       // agents.sort((a, b) -> Double.compare(b.getAverageRating(), a.getAverageRating())); no collision
        // Sort: avg rating (desc) → then name (asc)
        agents.sort((a, b) -> {
            int cmp = Double.compare(b.getAverageRating(), a.getAverageRating());
            if (cmp != 0) return cmp;
            return getCOmparator(a, b,this.tieBreaker);
        });
        return agents;


    }
















    private static int getCOmparator(Agent a, Agent b,TieBreaker tieBreaker) {
        int cmp = 0;
        switch (tieBreaker) {
            case TOTAL_SCORE:
                // higher total first
                cmp = Long.compare(b.totalRating, a.totalRating);
                if (cmp != 0) return cmp;
                break;

            case COUNT:
                // more ratings first
                cmp = Integer.compare(b.ratingCount, a.ratingCount);
                if (cmp != 0) return cmp;
                break;
            case NAME:
                // alphabetical ascending
                cmp = a.name.compareTo(b.name);
                if (cmp != 0) return cmp;
                break;
        }
        return a.name.compareTo(b.name);
    }

    public static void main(String[] args) {
        RatingService service = new RatingService(1,5,TieBreaker.NAME);

        service.giveRating("Alice", 5);
        service.giveRating("Bob", 3);
        service.giveRating("Alice", 4);
        service.giveRating("Charlie", 5);
        service.giveRating("Bob", 4);

        List<Agent> ratings = service.getRatings();
        for (Agent a : ratings) {
            System.out.println(a);
        }
    }


}
