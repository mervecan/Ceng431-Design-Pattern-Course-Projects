import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    public JsonHandler() throws IOException {
    }

    public static List<Artist> readJson() throws IOException {
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
        return artists;
    }

    public static void updateJson(List<Artist> artists) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("music.json");
        mapper.writeValue(file, artists);
    }

    public static void main(String[] args) throws IOException {
        List<Artist> artists = readJson();
        Song song = new Song("New Song", "4:15");
        List<Song> songs = new ArrayList<Song>();
        songs.add(song);
        Album album = new Album("New Album", "New album containing New Song", songs);
        System.out.println("/////////////////");
        artists.get(0).addAlbum(album);
        for(Album a: artists.get(0).getAlbums()){
            System.out.println("\t" + a.getTitle() + "'s songs: ");
            for(Song s: a.songs)
                System.out.println("\t\t" + s.getTitle());
        }
        updateJson(artists);


    }
}
