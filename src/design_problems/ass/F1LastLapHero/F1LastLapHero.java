package design_problems.ass.F1LastLapHero;

import java.util.HashMap;
import java.util.Map;

public class F1LastLapHero {
    public static void main(String[] args) {
        F1LastLapHero race = new F1LastLapHero();
        race.lapComplete("Driver1", 100);
        race.lapComplete("Driver2", 90);
        race.lapComplete("Driver3", 70);
        race.lapComplete("Driver1", 110);
        race.lapComplete("Driver2", 95);
        race.lapComplete("Driver3", 50);

        String hero = race.getLastLapHero();
        if ("Driver3".equals(hero)) {
            System.out.println("✅ testBasicScenario PASSED");
        } else {
            System.out.println("❌ testBasicScenario FAILED. Got: " + hero);
        }
    }

    private final Map<String, LapStats> driverLapsMap = new HashMap<>();


    // Record stats when lap is completed
    public void lapComplete(String driver, int lapTimeMs) {
        if (driver == null || driver.isEmpty()) {
            throw new IllegalArgumentException("driver cannot be null/empty");
        }
         driverLapsMap.computeIfAbsent(driver,k->new LapStats()).addLap(lapTimeMs);
    }

    // Determine Last Lap Hero
    // iterate and find max
    public String getLastLapHero() {
        String hero = null;
        Double bestImprovement = Double.MAX_VALUE;
        for (Map.Entry<String,LapStats>  driver :  driverLapsMap.entrySet()) {
           double lastLapGain = driver.getValue().calculateLastLapGain();
           if(! Double.isFinite(lastLapGain)) continue;//take care of zero
           if( lastLapGain  < bestImprovement){
               hero = driver.getKey();
               bestImprovement = lastLapGain;
           }
        }
        return hero;
    }
}
