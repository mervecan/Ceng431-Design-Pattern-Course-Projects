import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Artist implements IArtist {
    private String name;
    private List<Album> albums;
    @JsonIgnore
    int state;
    @JsonIgnore
    private List<IObserver> observers;

    public Artist(){
        albums = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
        observers = new ArrayList<>();
    }

    @Override
    public void addAlbum(Album album) {
        albums.add(album);
    }

    @Override
    public void removeAlbum(Album album) {
        if(albums.contains(album)){
            albums.remove(album);
        }
    }

    @Override
    public void update(ISubject iSubject) {
        Album subject = (Album)iSubject;
        Album album = new Album();
        for(Album temp: albums){
            if(temp.getTitle().equals(subject.getTitle())){

                albums.remove(album);
                albums.add(subject);
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

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
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
