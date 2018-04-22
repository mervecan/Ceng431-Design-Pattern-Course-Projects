import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Album implements IAlbum {
    private String title;
    private String description;
    private List<Song> songs;
    @JsonIgnore
    private List<IObserver> observers;
    @JsonIgnore
    private int state;

    public Album(){
        state = 0;
        observers = new ArrayList<>();
    }

    @JsonCreator
    public Album(@JsonProperty(value = "title", required = true) String title, @JsonProperty(value = "description", required = true) String description, @JsonProperty(value = "songs", required = true) List<Song> songs) {
        this.title = title;
        this.description = description;
        this.songs = songs;
        attachToSongs();
        state = 0;
        observers = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        setState(state+1);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
        setState(state+1);
    }

    @Override
    public void attachToSongs() {
        for(Song song: songs){
            song.attach(this);
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

    @Override
    public void addSong(Song song) {
        song.attach(this);
        songs.add(song);
        setState(state+1);
    }

    @Override
    public void removeSong(Song song) {
        if(songs.contains(song)) {
            for(Song s: songs){
                if(s.getTitle().equals(song.getTitle())){
                    s.detach(this);
                    break;
                }
            }
            songs.remove(song);
            setState(state + 1);
        }
    }

    @Override
    public void update(ISubject iSubject) {
        Song subject = (Song)iSubject;
        for(Iterator<Song> iterator = songs.iterator(); iterator.hasNext();){
            Song temp = iterator.next();
            if(temp.getTitle().equals(subject.getTitle())){
                iterator.remove();
                break;
            }
        }
        songs.add(subject);
    }

    @Override
    public void attach(IObserver iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void detach(IObserver iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void notifyAllObservers() {
        for(IObserver iObserver: observers){
            iObserver.update(this);
        }
    }
}
