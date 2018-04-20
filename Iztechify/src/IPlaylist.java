public interface IPlaylist extends IObserver, ISubject {
    void addSong(Song song);
    void removeSong(Song song);
}
