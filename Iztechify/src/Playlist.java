import java.util.ArrayList;
import java.util.List;

public class Playlist implements IPlaylist {
    private List<Song> songs;
    private int state;
    private List<IObserver> observers;

    public Playlist() {
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
