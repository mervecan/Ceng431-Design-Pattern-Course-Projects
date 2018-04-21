import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Meyin {
    public static void main(String[] args) {
        JsonHandler.getInstance().readJson();
        //Artist eklemeyi denedim çalışıyor;
        Admin admin = new Admin("Blabla", "asd");
        Song song = new Song("Song", "length");
        List<Song> songs = new ArrayList<>();
        songs.add(song);
        Album album = new Album("Album", "description", songs);
        List<Album> albums = new ArrayList<>();
        albums.add(album);
        Artist artist = new Artist("Artist", albums);
        System.out.println(artist.getAlbums().get(0).getTitle());
        admin.addArtist(artist);
        System.out.println(JsonHandler.getInstance().getArtistList().get(2).getName());

        //Burada da user deniyorum
        User user = new User("user", "uesr");
        JsonHandler.getInstance().addObject(user);
        System.out.println(JsonHandler.getInstance().getUserList().get(0).getName());

    }
}
