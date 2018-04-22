import java.io.IOException;
import java.util.List;

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
        artist.attach(this);
        JsonHandler.getInstance().addObject(artist);
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void addAlbum(Artist artist, Album album) {
        if(artist.getObservers().size() < 1)
            artist.attach(this);
        album.attach(this);
        int iArtist = JsonHandler.getInstance().getArtistList().indexOf(artist);
        JsonHandler.getInstance().getArtistList().get(iArtist).addAlbum(album);
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void addSong(Artist artist, Album album, Song song) {
        if(artist.getObservers().size() < 1)
            artist.attach(this);
        song.attach(this);
        int iArtist = JsonHandler.getInstance().getArtistList().indexOf(artist);
        int iAlbum = JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().indexOf(album);
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).addSong(song);
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void removeArtist(Artist artist) {
        JsonHandler.getInstance().removeObject(artist);
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void removeAlbum(Artist artist, Album album) {
        int iArtist = JsonHandler.getInstance().getArtistList().indexOf(artist);
        JsonHandler.getInstance().getArtistList().get(iArtist).removeAlbum(album);
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void removeSong(Artist artist, Album album, Song song) {
        int iArtist = JsonHandler.getInstance().getArtistList().indexOf(artist);
        int iAlbum = JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().indexOf(album);
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).removeSong(song);
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void editArtist(Artist artist, Artist newArtist) {
        if(artist.getObservers().size() < 1)
            artist.attach(this);
        int iArtist = JsonHandler.getInstance().getArtistList().indexOf(artist);
        JsonHandler.getInstance().getArtistList().get(iArtist).setName(newArtist.getName());
        JsonHandler.getInstance().getArtistList().get(iArtist).setAlbums(newArtist.getAlbums());
        JsonHandler.getInstance().getArtistList().get(iArtist).setObservers(newArtist.getObservers());
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void editAlbum(Artist artist, Album album, Album newAlbum) {
        if(artist.getObservers().size() < 1)
            artist.attach(this);
        int iArtist = JsonHandler.getInstance().getArtistList().indexOf(artist);
        int iAlbum = JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().indexOf(album);
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).setTitle(newAlbum.getTitle());
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).setDescription(newAlbum.getDescription());
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).setSongs(newAlbum.getSongs());
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).setObservers(newAlbum.getObservers());
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void editSong(Artist artist, Album album, Song song, Song newSong) {
        if(artist.getObservers().size() < 1)
            artist.attach(this);
        int iArtist = JsonHandler.getInstance().getArtistList().indexOf(artist);
        int iAlbum = JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().indexOf(album);
        int iSong = JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).getSongs().indexOf(song);
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).getSongs().get(iSong).setTitle(newSong.getTitle());
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).getSongs().get(iSong).setLength(newSong.getLength());
        JsonHandler.getInstance().getArtistList().get(iArtist).getAlbums().get(iAlbum).getSongs().get(iSong).setObservers(newSong.getObservers());
        JsonHandler.getInstance().updateJson();
    }

    @Override
    public void update(ISubject iSubject) {
        JsonHandler.getInstance().updateJson();
    }
}
