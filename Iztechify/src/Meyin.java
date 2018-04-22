import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Meyin {
    public static void main(String[] args) {
        JsonHandler.getInstance().readJson();
        //Artist eklemeyi denedim çalışıyor;
        Admin admin = new Admin("Blabla", "asd");

        int iArtist = 0;
        Song newSong = new Song("NewRadiohead", "Sekiz");
        Artist artist = JsonHandler.getInstance().getArtistList().get(0);
        Album album = artist.getAlbums().get(0);
        Song oldSong = album.getSongs().get(0);
        admin.editSong(artist, album, oldSong, newSong);

    }
}
