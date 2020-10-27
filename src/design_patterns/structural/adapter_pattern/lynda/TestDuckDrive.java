package design_patterns.structural.adapter_pattern.lynda;

import design_patterns.structural.adapter_pattern.lynda.drone.Drone;
import design_patterns.structural.adapter_pattern.lynda.drone.DroneAdapter;
import design_patterns.structural.adapter_pattern.lynda.drone.SuperDrone;

public class TestDuckDrive {

    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);

        //Challenge
        System.out.println("\nThe DroneAdapter says...");
        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);
        testDuck(droneAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
