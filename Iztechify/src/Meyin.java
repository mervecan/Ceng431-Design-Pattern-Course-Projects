import java.util.ArrayList;
import java.util.List;

public class Meyin {
    public static void main(String[] args) {
        Admin admin = new Admin("Admin admin", "1");
        for(Artist artist: admin.getArtistJsonHandler().getObjectList()){
            if(artist.getName().equals("Radiohead")){
                artist.attach(admin);
                Song song = new Song("Merve", "123");
                List<Song> songs = new ArrayList<>();
                songs.add(song);
                Album album = new Album("MerveTitle", "MerveDescription", songs);
                admin.addAlbum(artist, album);
            }
        }
    }
}
