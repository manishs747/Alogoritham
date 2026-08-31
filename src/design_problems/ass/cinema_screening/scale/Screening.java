package design_problems.ass.cinema_screening.scale;

import design_problems.ass.cinema_screening.Movie;

public class Screening {
    public int sart,end;
    public Movie movie;
    public  Screening(int start,int end,Movie movie){
        this.sart =  start;
        this.end = end;
        this.movie = movie;
    }
}
