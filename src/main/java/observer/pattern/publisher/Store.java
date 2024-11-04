package observer.pattern.publisher;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;

import observer.pattern.observers.Observer;

@Component
public class Store implements Publisher {
    private String message;
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    public String getMessage() {
        return message;
    }
}