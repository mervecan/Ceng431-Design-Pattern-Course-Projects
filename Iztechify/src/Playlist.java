import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Playlist implements IPlaylist {
    private String name;
    private List<Song> songs;
    @JsonIgnore
    private int state;
    @JsonIgnore
    private List<IObserver> observers;



    public Playlist() {
        state = 0;
        observers = new ArrayList<>();
    }

    @JsonCreator
    public Playlist(@JsonProperty(value = "name", required = true) String name) {
        this.name = name;
        state = 0;
        observers = new ArrayList<>();
    }

    @Override
    public void addSong(Song song) {
        song.attach(this);
        songs.add(song);
        setState(state+1);
    }

    @Override
    public void removeSong(Song song) {
        for(Song s: songs){
            if(s.getTitle().equals(song.getTitle())){
                s.detach(this);
                break;
            }
        }
        if(songs.contains(song)){
            songs.remove(song);
            setState(state+1);
        }
    }

    @Override
    public void update(ISubject iSubject) {
        Song subject = (Song)iSubject;
        for(Song song: songs){
            if(song.getTitle().equals(subject.getTitle())){
                songs.remove(song);
                songs.add(subject);
            }
        }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setState(state+1);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
        setState(state+1);

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
