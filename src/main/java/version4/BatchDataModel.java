package version4;

import java.util.ArrayList;
import java.util.List;

public class BatchDataModel {
    public List<Double> temperatures;
    private List<Observer>  observers = new ArrayList<>();


    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void setTemperatures(List<Double> temperatures) {
        if(!temperatures.equals(this.temperatures)){
            this.temperatures = temperatures;
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
