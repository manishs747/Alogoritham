package design_problems.ass.cinema_screening;

import java.util.Comparator;
import java.util.List;

public class CinemaScheduler {

    public static void main(String[] args) {

        MovieSchedule schedule = new MovieSchedule();
            schedule.addScreening(new Screening(600, 720));  // 10:00 - 12:00
            schedule.addScreening(new Screening(750, 870));  // 12:30 - 14:30
            schedule.addScreening(new Screening(900, 1020)); // 15:00 - 17:00

            Movie newMovie = new Movie(120);
            CinemaScheduler cs = new CinemaScheduler(600,1380);
            System.out.println("Can schedule new movie? " +
                    cs.canSchedule(newMovie, schedule)); // ✅ true (after 17:00)
        }



    private final int OPEN ,CLOSE;

    CinemaScheduler(int open,int close){
        OPEN = open;
        CLOSE = close;

    }



    public boolean canSchedule(Movie movie,MovieSchedule movieSchedule){
          if( movie.getDuration() > CLOSE - OPEN) return false;
          //add senital
          List<Screening> screenings = movieSchedule.getScreeningList();
          screenings.add(new Screening(OPEN,OPEN));
          screenings.add(new Screening(CLOSE,CLOSE));

        screenings.sort(Comparator.comparingInt(a->a.sart));
        for (int i = 1 ; i < screenings.size();i++){
            Screening prev = screenings.get(i-1) ,cur = screenings.get(i);
            if(cur.sart - prev.end >= movie.getDuration()){
                return true;
            }
        }
        return false;
    }
}
