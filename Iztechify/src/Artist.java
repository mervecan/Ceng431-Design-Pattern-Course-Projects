import java.util.ArrayList;
import java.util.List;

public class Artist implements IArtist {
    private String name;
    private List<Album> albums;
    int state;
    private List<IObserver> observers;

    public Artist(){
        albums = new ArrayList<>();
    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
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
        for(Album album: albums){
            if(album.getTitle().equals(subject.getTitle())){
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
