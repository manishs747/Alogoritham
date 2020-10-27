package design_patterns.behaviour.observer.lynda.simple;

public class SimpleObserver implements Observer {
    private int value;
    private Subject simpleSubject;

    public SimpleObserver(Subject simpleSubject) {
        this.simpleSubject = simpleSubject;
        simpleSubject.registerObserver(this);
    }

    public void update(int value) {
        this.value = value;
        display();
    }

    public void display() {
        System.out.println("SimpleObserver Value: " + value);
    }
}
