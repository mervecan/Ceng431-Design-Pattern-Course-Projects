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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
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
        if(iSubject.getClass().equals(User.class)){
            User subject = (User)iSubject;
            for(User friend: friends){
                if(friend.getName().equals(subject.getName())){
                    friends.remove(friend);
                    friends.add(subject);
                }
            }
        }
        else if(iSubject.getClass().equals(Playlist.class)){
            Playlist subject = (Playlist)iSubject;
            for(Playlist playlist: playlists){
                if(playlist.getName().equals(subject.getName())){
                    playlists.remove(playlist);
                    playlists.add(subject);
                }
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
