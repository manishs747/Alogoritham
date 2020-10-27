package design_patterns.behaviour.observer.lynda.simple;

public class TestSimple {

    public static void main(String[] args) {
        SimpleSubject simpleSubject = new SimpleSubject();
        new SimpleObserver(simpleSubject);
        simpleSubject.setValue(80);
    }
}
