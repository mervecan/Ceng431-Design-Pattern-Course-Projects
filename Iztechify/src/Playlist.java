import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public Playlist(String name) {
        this.name = name;
        state = 0;
        observers = new ArrayList<>();
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public void removeSong(Song song) {
        if(songs.contains(song)){
            songs.remove(song);
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
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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
