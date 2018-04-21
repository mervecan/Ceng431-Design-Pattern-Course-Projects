import java.io.IOException;

public class Admin implements IAdmin {
    private String name;
    private String password;
    private JsonHandler<Artist> artistJsonHandler;
    private JsonHandler<User> userJsonHandler;

    public Admin(){
        try {
            artistJsonHandler = new JsonHandler<>("music.json", Artist.class);
            userJsonHandler = new JsonHandler<>("music.json", User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
        try {
            artistJsonHandler = new JsonHandler<>("music.json", Artist.class);
//            userJsonHandler = new JsonHandler<>("music.json", User.class);
            artistJsonHandler.readJson();
//            userJsonHandler.readJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addArtist(Artist artist) {
        try {
            artistJsonHandler.addObject(artist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAlbum(Artist artist, Album album) {
        if(artistJsonHandler.getObjectList().contains(artist)){
            for(Artist a: artistJsonHandler.getObjectList()){
                if(a.getName().equals(artist.getName())) {
                    Artist newArtist = artist;
                    newArtist.addAlbum(album);
                    newArtist.setState(newArtist.getState()+1);
                }
            }
        }
    }


    public JsonHandler<Artist> getArtistJsonHandler() {
        return artistJsonHandler;
    }

    public void setArtistJsonHandler(JsonHandler<Artist> artistJsonHandler) {
        this.artistJsonHandler = artistJsonHandler;
    }

    public JsonHandler<User> getUserJsonHandler() {
        return userJsonHandler;
    }

    public void setUserJsonHandler(JsonHandler<User> userJsonHandler) {
        this.userJsonHandler = userJsonHandler;
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
        if(iSubject.getClass().equals(User.class)){
            User subject = (User)iSubject;
            for(User user: userJsonHandler.getObjectList()){
                if(user.getName().equals(subject.getName())){
                    try {
                        userJsonHandler.removeObject(user);
                        userJsonHandler.addObject(subject);
                        userJsonHandler.updateJson();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if(iSubject.getClass().equals(Artist.class)){
            Artist subject = (Artist) iSubject;
            Artist artist = new Artist();
            for(Artist temp: artistJsonHandler.getObjectList()){
                if(temp.getName().equals(subject.getName())){
                    artist = temp;
                    break;
                }
            }
            try {
                artistJsonHandler.removeObject(artist);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
