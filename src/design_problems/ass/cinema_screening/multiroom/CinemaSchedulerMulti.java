package design_problems.ass.cinema_screening.multiroom;

import design_problems.ass.cinema_screening.Movie;
import design_problems.ass.cinema_screening.scale.MovieSchedule;
import design_problems.ass.cinema_screening.scale.Screening;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CinemaSchedulerMulti {

    private static final int OPEN = 600;   // 10:00
    private static final int CLOSE = 1380; // 23:00


    // --- Single Room canSchedule ---
    public static boolean canSchedule(Movie movie, MovieSchedule schedule) {
        if (movie.getDuration() > (CLOSE - OPEN)) return false;

        List<Screening> list = new ArrayList<>(schedule.getScreeningList());
        // add sentinels
        list.add(new Screening(OPEN, OPEN, null));
        list.add(new Screening(CLOSE, CLOSE, null));
        list.sort(Comparator.comparingInt(s -> s.sart));

        for (int i = 0; i < list.size() - 1; i++) {
            int gap = list.get(i + 1).sart - list.get(i).end;
            if (gap >= movie.getDuration()) return true;
        }
        return false;
    }

    // --- Multi Room canSchedule ---
    public static boolean canSchedule(Movie movie, Cinema cinema) {
        for (Room room : cinema.getRooms()) {
            if (canSchedule(movie, room.getSchedule())) {
                return true;
            }
        }
        return false;
    }

    // --- Single Room planScreening (remove one movie to fit new) ---
    public static Screening planScreening(Movie newMovie, MovieSchedule schedule) {
        Screening bestToRemove = null;
        int bestGain = Integer.MIN_VALUE;

        for (Screening s : new ArrayList<>(schedule.getScreeningList())) {
            schedule.getScreeningList().remove(s);

            if (canSchedule(newMovie, schedule)) {
                int gain = newMovie.getPrice() - s.movie.getPrice();
                if (gain > bestGain) {
                    bestGain = gain;
                    bestToRemove = s;
                }
            }

            schedule.getScreeningList().add(s); // restore
        }
        return bestToRemove;
    }
    // --- Multi Room planScreening ---
    public static Screening planScreening(Movie newMovie, Cinema cinema) {
        Screening bestToRemove = null;
        int bestGain = Integer.MIN_VALUE;

        for (Room room : cinema.getRooms()) {
            Screening candidate = planScreening(newMovie, room.getSchedule());
            if (candidate != null) {
                int gain = newMovie.getPrice() - candidate.movie.getPrice();
                if (gain > bestGain) {
                    bestGain = gain;
                    bestToRemove = candidate;
                }
            }
        }
        return bestToRemove;
    }

    // --- Revenue Calculation (Single Room) ---
    public static int totalRevenue(MovieSchedule schedule) {
        int total = 0;
        for (Screening s : schedule.getScreeningList()) {
            if (s.movie != null) total += s.movie.getPrice();
        }
        return total;
    }

    // --- Revenue Calculation (Multi Room) ---
    public static int totalRevenue(Cinema cinema) {
        int total = 0;
        for (Room room : cinema.getRooms()) {
            total += totalRevenue(room.getSchedule());
        }
        return total;
    }


}
