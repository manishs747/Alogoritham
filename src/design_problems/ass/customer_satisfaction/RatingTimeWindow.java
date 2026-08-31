package design_problems.ass.customer_satisfaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingTimeWindow {

    private final Map<String, Map<String, Agent>> ratings = new HashMap<>();

    private static final DateTimeFormatter MONTH_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM");


   private String getWindowKey(LocalDate local){
      return local.format(MONTH_FORMAT);
   }

    public void giveRating(String agentName, int rating, LocalDate date) {
        if (agentName == null || agentName.isEmpty()) {
            throw new IllegalArgumentException("Agent name required");
        }
        String window = getWindowKey(date);

        Map<String, Agent> byWindow = ratings.computeIfAbsent(agentName, k -> new HashMap<>());
        byWindow.computeIfAbsent(window,k-> new Agent(agentName)).addRating(rating);
    }

    public List<Agent> getRatings(String window) { // 2025-01//
        List<Agent> results = new ArrayList<>();

        for (Map<String, Agent> perWindow : ratings.values()){
           if(perWindow.containsKey(window)){
               results.add(perWindow.get(window));
           }
        }
        results.sort((a, b) -> {
            int comp = Double.compare(b.getAverageRating(),a.getAverageRating());
            if(comp != 0){
                return comp;
            }else{
                return a.name.compareTo(b.name);
            }
        });
        return results;
    }

    public static void main(String[] args) {
        RatingTimeWindow service = new RatingTimeWindow();

        service.giveRating("Alice", 5, LocalDate.of(2025, 1, 10));
        service.giveRating("Alice", 3, LocalDate.of(2025, 1, 20));
        service.giveRating("Bob", 4, LocalDate.of(2025, 1, 15));
        service.giveRating("Bob", 2, LocalDate.of(2025, 2, 5));
        service.giveRating("Charlie", 5, LocalDate.of(2025, 1, 30));

        System.out.println("January Ratings: " + service.getRatings("2025-01"));
        System.out.println("February Ratings: " + service.getRatings("2025-02"));
    }


}
