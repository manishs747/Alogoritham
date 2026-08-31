package design_problems.ass.F1LastLapHero.scaleup;

public class LapStats {


    private int totalLapTimeAll = 0;
    private int totalLapsAll = 0;
    private long totalLapTimeNoPit = 0L;
    private int totalLapsNoPit = 0;
    private int lastLapTime = 0;

    public void addLap(int lapTimeMs, boolean isPitStop) {
        totalLapTimeAll += lapTimeMs;
        totalLapsAll++;
        lastLapTime = lapTimeMs;

        //if not pitstop extra check
        if(!isPitStop){
            totalLapTimeNoPit += lapTimeMs;
            totalLapsNoPit++;
        }
    }


    public double calculateLastLapGain( boolean includePitStops) {
        double avg = getAvg(includePitStops);
        return lastLapTime - avg;
    }

    private double getAvg(boolean includePitStops) {
        double avg;
        if(includePitStops){
            avg = totalLapsAll == 0 ? 0 : totalLapTimeAll/totalLapsAll;
        } else {
            avg = totalLapsNoPit == 0 ? 0 : totalLapTimeNoPit/totalLapsNoPit;
        }
        return avg;
    }


}
