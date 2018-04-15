import java.util.List;

public class Artist {
    String name;
    List<Album> albums;

    public Artist(){

    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album){
        albums.add(album);
    }

    public void deleteAlbum(Album album){
        albums.remove(album);
    }
}
