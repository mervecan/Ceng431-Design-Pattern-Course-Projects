import java.io.IOException;

public class Admin implements IAdmin {
    private String name;
    private String password;

    public Admin(){
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public void addArtist(Artist artist) {
        JsonHandler.getInstance().addObject(artist);
    }

    @Override
    public void addAlbum(Artist artist, Album album) {

    }

    @Override
    public void addSong(Artist artist, Album album, Song song) {

    }

    @Override
    public void removeArtist(Artist artist) {

    }

    @Override
    public void removeAlbum(Artist artist, Album album) {

    }

    @Override
    public void removeSong(Artist artist, Album album, Song song) {

    }

    @Override
    public void editArtist(Artist artist, Artist newArtist) {

    }

    @Override
    public void editAlbum(Artist artist, Album album, Album newAlbum) {

    }

    @Override
    public void editSong(Artist artist, Album album, Song song, Song newSong) {

    }

    @Override
    public void update(ISubject iSubject) {

    }
}
