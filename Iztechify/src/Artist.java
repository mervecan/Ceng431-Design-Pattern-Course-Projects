import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Artist implements IArtist {
    private String name;
    @JsonProperty
    private List<Album> albums;
    @JsonIgnore
    int state;
    @JsonIgnore
    private List<IObserver> observers;

    public Artist(){
        albums = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @JsonCreator
    public Artist(@JsonProperty(value = "name", required = true) String name, @JsonProperty(value = "albums", required = true) List<Album> albums) {
        this.name = name;
        this.albums = albums;
        attachToAlbums();
        observers = new ArrayList<>();
        observers.add(JsonHandler.getInstance());
    }

    @Override
    public void addAlbum(Album album) {
        album.attach(album);
        albums.add(album);
        setState(state+1);
    }

    @Override
    public void removeAlbum(Album album) {
        for(Album a: albums){
            if(a.getTitle().equals(album.getTitle())){
                a.detach(this);
                break;
            }
        }
        if(albums.contains(album)){
            albums.remove(album);
            setState(state+1);
        }
    }

    @Override
    public void attachToAlbums() {
        for(Album album: albums){
            album.attach(this);
        }
    }

    @Override
    public void update(ISubject iSubject) {
        Album subject = (Album)iSubject;
        for(Iterator<Album> iterator = albums.iterator(); iterator.hasNext();){
            Album temp = iterator.next();
            if(temp.getTitle().equals(subject.getTitle())){
                iterator.remove();
                break;
            }
        }
        albums.add(subject);
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

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
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
