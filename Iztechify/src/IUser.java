public interface IUser extends IObserver, ISubject {
    void createPlaylist();
    void addSongToPlaylist(Playlist playlist, Song song);
    void removeSongFromPlaylist(Playlist playlist, Song song);
    void addFriend(IUser friend);
    void removeFriend(IUser friend);
}
