public interface IArtist extends IObserver, ISubject {
    void addAlbum(Album album);
    void removeAlbum(Album album);
    void attachToAlbums();
}
