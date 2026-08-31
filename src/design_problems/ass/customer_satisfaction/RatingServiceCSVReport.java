package design_problems.ass.customer_satisfaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RatingServiceCSVReport {

    private final Map<String, Map<String, Agent>> ratings = new HashMap<>();
    private static final DateTimeFormatter MONTH_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM");


    private String getWindow(LocalDate date) {
        return date.format(MONTH_FORMAT); // "2025-09"
    }

    public void giveRating(String agentName, int rating, LocalDate date) {
        String window = getWindow(date);
        Map<String, Agent> byWindow = ratings.computeIfAbsent(agentName, k -> new HashMap<>());
        byWindow.computeIfAbsent(window,k->new Agent(agentName)).addRating(rating);
    }

    public String exportRatingsCsv() {

        // Collect all months across all agents  // collect all mo
        Set<String> allMonths = new TreeSet<>(); // sorted
        for (Map<String, Agent> perWindow : ratings.values()) {
            allMonths.addAll(perWindow.keySet());
        }

        // Build CSV
        StringBuilder sb = new StringBuilder();
        sb.append("Agent");
        for (String month : allMonths) {
            sb.append(",").append(month);
        }
        sb.append("\n");

        for (String agentName : ratings.keySet()) {
            sb.append(agentName);
            Map<String, Agent> perWindow = ratings.get(agentName);
            for (String month : allMonths) {
                Agent a = perWindow.get(month);
                double avg = (a == null) ? 0.0 : a.getAverageRating();
                sb.append(",").append(String.format("%.2f", avg));
            }
            sb.append("\n");
        }
        return sb.toString();
    }





}
