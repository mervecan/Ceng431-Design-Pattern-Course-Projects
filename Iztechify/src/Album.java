import java.util.ArrayList;
import java.util.List;

public class Album implements IAlbum {
    private String title;
    private String description;
    private List<Song> songs;
    private List<IObserver> observers;
    private int state;

    public Album(){
        state = 0;
        observers = new ArrayList<>();
    }

    public Album(String title, String description, List<Song> songs) {
        this.title = title;
        this.description = description;
        this.songs = songs;
        state = 0;
        observers = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        songs.add(song);
    }

    @Override
    public void removeSong(Song song) {
        if(songs.contains(song))
            songs.remove(song);
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
