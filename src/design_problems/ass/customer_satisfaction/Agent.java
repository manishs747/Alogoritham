package design_problems.ass.customer_satisfaction;

public class Agent {
   public String name;
    int totalRating;
    int ratingCount;

   public Agent(String name){
        this.name = name;
        this.ratingCount = 0;
        this.totalRating = 0;
    }

    public void addRating(int rating){
        totalRating += rating;
        ratingCount++;
    }

   public double getAverageRating() {
        return ratingCount == 0 ? 0 : (double) totalRating/ratingCount;
    }

    public String toString() {
        return name + ": " + String.format("%.2f", getAverageRating());
    }
}
