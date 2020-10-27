package design_patterns.structural.adapter_pattern.lynda;

public class WildTurkey implements Turkey{

    public void gobble() {
        System.out.println("Gobble gobble");
    }

    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
