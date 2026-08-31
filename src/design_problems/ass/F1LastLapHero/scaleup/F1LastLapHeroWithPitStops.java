package design_problems.ass.F1LastLapHero.scaleup;

import java.util.HashMap;
import java.util.Map;

public class F1LastLapHeroWithPitStops {

    public static void main(String[] args) {
        F1LastLapHeroWithPitStops race = new F1LastLapHeroWithPitStops();

        race.lapComplete("Driver1", 100, false);
        race.lapComplete("Driver2", 80, true);
        race.lapComplete("Driver1", 120, true);
        race.lapComplete("Driver2", 100, false);
        race.lapComplete("Driver1", 130, false);
        race.lapComplete("Driver2", 100, false);
        race.lapComplete("Driver1", 110, false);
        race.lapComplete("Driver2", 90, true);

        String heroIncl = race.getLastLapHero(true);
        String heroExcl = race.getLastLapHero(false);

        System.out.println("Including pit stops Hero: " + heroIncl); // Expected Driver1
        System.out.println("Excluding pit stops Hero: " + heroExcl); // Expected Driver2
    }

    private final Map<String, LapStats> driverLapsMap = new HashMap<>();

    public void lapComplete(String driver, int lapTimeMs, boolean isPitStop) {
        if (driver == null || driver.isEmpty()) {
            throw new IllegalArgumentException("driver cannot be null/empty");
        }

        driverLapsMap.computeIfAbsent(driver,k->new LapStats()).addLap(lapTimeMs,isPitStop);
    }

    public String getLastLapHero(boolean includePitStops) {
        String hero = null;
        double bestImprovement = Double.POSITIVE_INFINITY;

        for (Map.Entry<String,LapStats>  entry : driverLapsMap.entrySet()){
            String driver  = entry.getKey();
            LapStats lapstats = entry.getValue();
            double gain =  lapstats.calculateLastLapGain(includePitStops);
            if(!Double.isFinite(gain)) continue;
            if(gain < bestImprovement) {
                bestImprovement = gain;
                hero = driver;
            }
        }
        return  hero;
    }



}
