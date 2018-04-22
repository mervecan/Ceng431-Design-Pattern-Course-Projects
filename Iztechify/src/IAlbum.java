public interface IAlbum extends ISubject, IObserver {
    void addSong(Song song);
    void removeSong(Song song);
    void attachToSongs();
}
