public interface IUser extends ISubject, IObserver {
    void createPlaylist();
    void addSongToPlaylist(Playlist playlist, Song song);
    void removeSongFromPlaylist(Playlist playlist, Song song);
    void addFriend(IUser friend);
    void removeFriend(IUser friend);
    boolean login(String userName, String password);
    boolean register(String userName, String password);
}
