package design_problems.ass.cinema_screening.multiroom;

import design_problems.ass.cinema_screening.scale.MovieSchedule;

public class Room {
    private MovieSchedule schedule;

    public Room(MovieSchedule schedule) {
        this.schedule = schedule;
    }

    public MovieSchedule getSchedule() {
        return schedule;
    }


}
