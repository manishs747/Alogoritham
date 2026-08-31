package design_problems.ass.F1LastLapHero.observer;



import design_problems.ass.F1LastLapHero.scaleup.LapStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class F1LastLapHeroWithTelemetry {

    private final Map<String, LapStats> driverLapsMap = new HashMap<>();
    private final List<HeroChangeListener> listeners = new ArrayList<>();

    private String currentHero = null;

    public void lapComplete(String driver, int lapTimeMs, boolean isPitStop) {
        driverLapsMap.computeIfAbsent(driver, k -> new LapStats()).addLap(lapTimeMs, isPitStop);
    }

    public String getLastLapHero(boolean includePitStops) {
        String hero = null;
        double bestImprovement = Double.POSITIVE_INFINITY;

        for (Map.Entry<String, LapStats> entry : driverLapsMap.entrySet()) {
            String driver = entry.getKey();
            LapStats lapStats = entry.getValue();
            double gain = lapStats.calculateLastLapGain(includePitStops);
            if (!Double.isFinite(gain)) continue;
            if (gain < bestImprovement) {
                bestImprovement = gain;
                hero = driver;
            }
        }

        // notify if hero changed
        if (hero != null && !hero.equals(currentHero)) {
            notifyHeroChange(currentHero, hero);
            currentHero = hero;
        }

        return hero;
    }

    public void addListener(HeroChangeListener listener) {
        listeners.add(listener);
    }

    private void notifyHeroChange(String oldHero, String newHero) {
        for (HeroChangeListener listener : listeners) {
            listener.onHeroChange(oldHero, newHero);
        }
    }

    public static void main(String[] args) {
        F1LastLapHeroWithTelemetry race = new F1LastLapHeroWithTelemetry();

        // Add telemetry listener
        race.addListener((oldHero, newHero) ->
                System.out.println("[Telemetry] Hero changed from " + oldHero + " → " + newHero));

        race.lapComplete("Driver1", 100, false);
        race.lapComplete("Driver2", 90, false);
        race.lapComplete("Driver3", 70, false);

        System.out.println("Hero: " + race.getLastLapHero(true));

        race.lapComplete("Driver3", 50, false);
        System.out.println("Hero: " + race.getLastLapHero(true));

        race.lapComplete("Driver1", 110, false);
        System.out.println("Hero: " + race.getLastLapHero(true));
    }
}
