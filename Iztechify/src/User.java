import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements IUser {
    private String name;
    private String password;
    private List<Playlist> playlists;
    private List<IUser> friends;
    @JsonIgnore
    private int state;  //json ignore
    @JsonIgnore
    private List<IObserver> observers; //json ignore

    public User(){
        friends = new ArrayList<>();
        playlists = new ArrayList<>();
        observers = new ArrayList<>();
        observers.add(JsonHandler.getInstance());
    }

    @JsonCreator
    public User(@JsonProperty(value = "name", required = true) String name, @JsonProperty(value = "password", required = true) String password) {
        this.name = name;
        this.password = password;
        friends = new ArrayList<>();
        playlists = new ArrayList<>();
        observers = new ArrayList<>();
        observers.add(JsonHandler.getInstance());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setState(state+1);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        setState(state+1);
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
        setState(state+1);
    }

    public List<IUser> getFriends() {
        return friends;
    }

    public void setFriends(List<IUser> friends) {
        this.friends = friends;
        setState(state+1);
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
    public void createPlaylist() {
        Playlist playlist = new Playlist();
        playlists.add(playlist);
    }

    @Override
    public void addSongToPlaylist(Playlist playlist, Song song) {
        playlist.addSong(song);
        setState(state+1);
    }

    @Override
    public void removeSongFromPlaylist(Playlist playlist, Song song) {
        playlist.removeSong(song);
        setState(state+1);
    }

    @Override
    public void addFriend(IUser friend) {
        friend.attach(this);
        friends.add(friend);
        setState(state+1);
    }

    @Override
    public void removeFriend(IUser friend) {
        User f = (User)friend;
        if(friends.contains(friend)){
            for(IUser u: friends){
                if(((User)u).getName().equals(f.getName())){
                    friend.detach(this);
                    break;
                }
            }
            friends.remove(friend);
            setState(state+1);
        }
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

	@Override
	public boolean login(String userName, String password) {
		for(User user : JsonHandler.getInstance().getUserList()) {
				if(user.getName().equals(userName)&&user.getPassword().equals(password))
				return true;
		}
		return false;
	}

	@Override
	public boolean register(String userName, String password) {
        return JsonHandler.getInstance().addObject(new User(userName, password));
	}


    @Override
    public void update(ISubject iSubject) {
        JsonHandler.getInstance().updateJson();
    }
}
