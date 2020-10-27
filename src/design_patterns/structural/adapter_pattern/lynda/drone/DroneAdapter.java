package design_patterns.structural.adapter_pattern.lynda.drone;

import design_patterns.structural.adapter_pattern.lynda.Duck;

public class DroneAdapter implements Duck {
    Drone drone;

    public DroneAdapter(Drone drone) {
        this.drone = drone;
    }

    public void quack() {
        drone.beep();
    }

    public void fly() {
        drone.spin_rotors();
        drone.take_off();
    }
}
