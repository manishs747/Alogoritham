package design_problems.ass.cinema_screening.scale;



import java.util.ArrayList;
import java.util.List;

public class MovieSchedule {
    private final List<Screening> screeningList = new ArrayList<>();

    public void addScreening(Screening screening){
        this.screeningList.add(screening);
    }

    public  List<Screening>  getScreeningList() {
        return this.screeningList;
    }
}
