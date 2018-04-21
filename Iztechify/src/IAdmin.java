public interface IAdmin extends IObserver {
    void addArtist(Artist artist);
    void addAlbum(Artist artist, Album album);
    void addSong(Artist artist, Album album, Song song);
    void removeArtist(Artist artist);
    void removeAlbum(Artist artist, Album album);
    void removeSong(Artist artist, Album album, Song song);
    void editArtist(Artist artist, Artist newArtist);
    void editAlbum(Artist artist, Album album, Album newAlbum);
    void editSong(Artist artist, Album album, Song song, Song newSong);
}
