package observer.pattern.publisher;

import observer.pattern.observers.Observer;

public interface Publisher {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setMessage(String message);
}