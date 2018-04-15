import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHandler {

    public JsonHandler() throws IOException {
    }

    public static void readJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("music.json");
        List<Artist> artists = mapper.readValue(file, new TypeReference<List<Artist>>(){});
        for(Artist artist: artists) {
            System.out.println(artist.getName() + "'s albums: ");
            for(Album album: artist.getAlbums()){
                System.out.println("\t" + album.getTitle() + "'s songs: ");
                for(Song song: album.songs)
                    System.out.println("\t\t" + song.getTitle());
            }
        }

    }

    public static void main(String[] args) throws IOException {
        readJson();
    }
}
