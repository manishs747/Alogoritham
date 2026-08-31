package design_problems.ass.F1LastLapHero;

public class LapStats {
    private int totalLapTime;
    private int totalLaps;
    private int lastLapTime;

   public void addLap(int lapTime){
        this.totalLapTime += lapTime;
        this.totalLaps++;
        this.lastLapTime = lapTime;
    }

    public double getAverageLapTime(){
        return totalLaps == 0 ? 0: (double) totalLapTime/totalLaps;
    }

    public double calculateLastLapGain() {
        if(totalLaps == 0) return 0;
        return lastLapTime - getAverageLapTime();
    }

    public int getTotalLaps(){
        return totalLaps;
    }
}
