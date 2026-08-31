package Interview.delivero.coding;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class cronparsing {

    public static void main(String[] args) {
        /*
        Goal:
              Write a program that parses a standard cron expression (e.g., "5 * /2 2-5 * * ") and computes the next N firing times after a given starting timestamp
              ┌───────────── minute (0–59)
│ ┌───────────── hour (0–23)
│ │ ┌───────────── day of month (1–31)
│ │ │ ┌───────────── month (1–12)
│ │ │ │ ┌───────────── day of week (0–6) (Sunday=0)
│ │ │ │ │
│ │ │ │ │
* * * * *

| Operator          | Example        | Meaning                   |
| ----------------- | -------------- | ------------------------- |
| `*`               | `*`            | All possible values       |
| `,`               | `1,3,5`        | Specific values           |
| `-`               | `2-5`          | Range inclusive (2,3,4,5) |
| `/`               | `* /15`         | Step (every 15 units)     |
                | Wrap-around range | `5-2` (in DOW) | e.g., 5,6,0,1,2           |


         */


        String cronExp = "5 */2 2-5 * *";

        String expr = "5 */2 2-5 * *";
        LocalDateTime start = LocalDateTime.of(2025, 10, 17, 1, 0);
        List<LocalDateTime> next = nextExecutions(expr, start, 5);
        next.forEach(System.out::println);
    }


    private static final Map<String, Integer> FIELD_LIMITS = Map.of(
            "minute", 59,
            "hour", 23,
            "day", 31,
            "month", 12,
            "weekday", 6
    );

    public static List<LocalDateTime> nextExecutions(
            String expr, LocalDateTime start, int count) {

        String[] parts = expr.trim().split("\\s+");
        if (parts.length != 5) throw new IllegalArgumentException("Invalid cron expression");
        List<Integer> mins = parseField(parts[0], "minute");
        List<Integer> hrs = parseField(parts[1], "hour");
        List<Integer> days = parseField(parts[2], "day");
        List<Integer> months = parseField(parts[3], "month");
        List<Integer> wdays = parseField(parts[4], "weekday");

        List<LocalDateTime> result = new ArrayList<>();
        LocalDateTime time = start.plusMinutes(1);
        while (result.size() < count) {
            if (mins.contains(time.getMinute()) &&
                    hrs.contains(time.getHour()) &&
                    days.contains(time.getDayOfMonth()) &&
                    months.contains(time.getMonthValue()) &&
                    wdays.contains(time.getDayOfWeek().getValue() % 7)) {
                result.add(time);
            }
            time = time.plusMinutes(1);
        }
        return result;
    }

    /**
     *      minute:  * /15  → [0,15,30,45]
            * hour:2-5   → [2,3,4,5]
            * day: *     → [1–31]
            * month: *     → [1–12]
            *  1,3,5 → [1,3,5]
     *
     */

    private static List<Integer> parseField(String expr, String fieldName) {
        int max = FIELD_LIMITS.get(fieldName);
        Set<Integer> result = new TreeSet<>();
        for(String  part : expr.split(",")) {
            String type = getPartType(part);
            switch (type) {
                case "STAR" -> {
                    IntStream.rangeClosed(0, max).forEach(result::add);
                }
                case "STEP" -> {
                    String[] stepParts = part.split("/");
                    String base = stepParts[0];
                    int step = Integer.parseInt(stepParts[1]);
                    List<Integer> baseRange = base.equals("*")
                            ? IntStream.rangeClosed(0, max).boxed().toList()
                            : parseRange(base, max);
                    for (int i = 0; i < baseRange.size(); i += step)
                        result.add(baseRange.get(i));
                }
                case "RANGE" -> result.addAll(parseRange(part, max));
                case "NUMBER" -> result.add(Integer.parseInt(part));
                default -> throw new IllegalArgumentException("Invalid cron token: " + part);
            }
        }
        return new ArrayList<>(result);
    }

    static String getPartType(String part) {
        if (part.equals("*")) return "STAR";
        if (part.contains("/")) return "STEP";
        if (part.contains("-")) return "RANGE";
        return "NUMBER";
    }

    static private  List<Integer> parseRange(String part, int max) {
        String[] bounds = part.split("-");
        int start = Integer.parseInt(bounds[0]);
        int end = Integer.parseInt(bounds[1]);
        List<Integer> vals = new ArrayList<>();
        if (start <= end) {
            for (int i = start; i <= end; i++)
                vals.add(i);
        } else {
            for (int i = start; i <= max; i++)
                vals.add(i);
            for (int i = 0; i <= end; i++)
                vals.add(i);
        }
        return vals;
    }



}