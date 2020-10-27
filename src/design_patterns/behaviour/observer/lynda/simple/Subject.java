package design_patterns.behaviour.observer.lynda.simple;



public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
