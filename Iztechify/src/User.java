import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String name;
    private String password;
    private List<Playlist> playlists;
    private List<User> friends;
    private int state;
    private List<IObserver> observers;
    public User(){
        friends = new ArrayList<>();
        playlists = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        friends = new ArrayList<>();
        playlists = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public void createPlaylist() {
        Playlist playlist = new Playlist();
        playlists.add(playlist);
    }

    @Override
    public void addSongToPlaylist(Playlist playlist, Song song) {
        playlist.addSong(song);
    }

    @Override
    public void removeSongFromPlaylist(Playlist playlist, Song song) {

    }

    @Override
    public void addFriend(IUser friend) {

    }

    @Override
    public void removeFriend(IUser friend) {

    }

    @Override
    public void update(ISubject iSubject) {

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
