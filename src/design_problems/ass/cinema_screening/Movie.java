package design_problems.ass.cinema_screening;

public class Movie {
    private final int  duration;
    private final int price ;

    Movie(int duration){
        this.duration = duration;
        price = 0;
    }

    public Movie(int duration , int price){
        this.duration = duration;
        this.price = price;
    }

    public int getDuration(){
        return duration;
    }

    public  int getPrice(){
        return price;
    }

}
