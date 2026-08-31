package design_problems.ass.cinema_screening.scale;

import design_problems.ass.cinema_screening.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CinemaScheduler {

    private final int OPEN ,CLOSE;

    CinemaScheduler(int open,int close){
        OPEN = open;
        CLOSE = close;

    }

    public static int totalRevenue(MovieSchedule schedule) {
        int total = 0;
        for (Screening s : schedule.getScreeningList()) {
            if (s.movie != null) {
                total += s.movie.getPrice();
            }
        }
        return total;
    }

    public boolean canSchedule(Movie movie, MovieSchedule movieSchedule){
        if( movie.getDuration() > CLOSE - OPEN) return false;
        //add senital
        List<Screening> screenings = movieSchedule.getScreeningList();
        screenings.add(new Screening(OPEN,OPEN , new Movie(0,0)));
        screenings.add(new Screening(CLOSE,CLOSE,new Movie(0,0)));

        screenings.sort(Comparator.comparingInt(a->a.sart));
        for (int i = 1 ; i < screenings.size();i++){
            Screening prev = screenings.get(i-1) ,cur = screenings.get(i);
            if(cur.sart - prev.end >= movie.getDuration()){
                return true;
            }
        }
        return false;
    }


    public  Screening planScreening(Movie newMovie, MovieSchedule schedule) {
        Screening bestToRemove = null;
        int bestGain = Integer.MIN_VALUE;
        for (Screening s : new ArrayList<>(schedule.getScreeningList())) {
            schedule.getScreeningList().remove(s);
            if(canSchedule(newMovie,schedule)){
                int curGain = newMovie.getPrice()-s.movie.getPrice();
                if(curGain > bestGain){
                   bestGain  = curGain;
                   bestToRemove = s;
               }
            }
            schedule.addScreening(s);
        }
      return bestToRemove;
    }

}
