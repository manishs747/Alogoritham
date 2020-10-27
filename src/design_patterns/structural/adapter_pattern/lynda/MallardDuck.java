package design_patterns.structural.adapter_pattern.lynda;

public class MallardDuck implements Duck{
    public void quack() {
        System.out.println("Quack");
    }

    public void fly() {
        System.out.println("I'm flying");
    }
}
