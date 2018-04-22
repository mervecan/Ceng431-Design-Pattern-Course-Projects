import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Song implements ISong {
    private String title;
    private String length;
    @JsonIgnore
    private List<IObserver> observers;
    @JsonIgnore
    private int state;

    public Song(){
        observers = new ArrayList<>();
        state = 0;
    }

    @JsonCreator
    public Song(@JsonProperty(value = "title", required = true) String title, @JsonProperty(value = "length", required = true) String length) {
        this.title = title;
        this.length = length;
        observers = new ArrayList<>();
        state = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        setState(state+1);
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
        setState(state+1);
    }

    public List<IObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<IObserver> observers) {
        this.observers = observers;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    @Override
    public void attach(IObserver iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void detach(IObserver iObserver) {
        observers.remove(iObserver);
    }

    @Override
    public void notifyAllObservers() {
        for(IObserver iObserver: observers){
            iObserver.update(this);
        }
    }
}
