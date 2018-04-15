import java.util.List;

public class Album {
    String title;
    String description;
    List<Song> songs;

    public Album(){

    }

    public Album(String title, List<Song> songs) {
        this.title = title;
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void deleteSong(Song song){
        songs.remove(song);
    }
}
