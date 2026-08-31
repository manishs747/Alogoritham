package design_problems.ass.cinema_screening.multiroom;

import java.util.List;

public class Cinema {
    private List<Room> rooms;

    public Cinema(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
