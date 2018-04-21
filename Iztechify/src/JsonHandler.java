import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO add edit function
public class JsonHandler implements IJsonHandler {
    private File userFile;
    private File musicFile;
    private ObjectMapper mapper;
    private List<User> users;
    private List<Artist> artists;

    private static final JsonHandler instance = new JsonHandler("user.json", "music.json");

    public static JsonHandler getInstance(){
        return instance;
    }

    private JsonHandler(String userFilePath, String musicFilePath) {
        this.userFile = new File(userFilePath);
        this.musicFile = new File(musicFilePath);
        this.users = new ArrayList<>();
        this.artists = new ArrayList<>();
        this.mapper = new ObjectMapper();
    }

    @Override
    public void readJson() {
        try {
            this.artists = this.mapper.readValue(this.musicFile, new TypeReference<List<Artist>>(){});
            this.users = this.mapper.readValue(this.userFile, new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateJson(){
        try {
            this.mapper.writeValue(userFile, users);
            this.mapper.writeValue(musicFile, artists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
	public boolean removeObject(ISubject subject){
        if(subject.getClass().equals(User.class)) {
            if (users.contains((User)subject)) {
                users.remove((User)subject);
                updateJson();

                return true;
            }
        }
        else if (artists.contains((Artist)subject)) {
            artists.remove((Artist)subject);
            return true;
        }

        return false;
    }

    @Override
    public void update(ISubject iSubject) {
        updateJson();
    }

    @Override
    public boolean addObject(ISubject subject){
        //TODO: Modify so that if object exists it modifies it.
        if(subject.getClass().equals(User.class)) {
            if (users.contains((User)subject)) {
                return false;
            }
            else{
                users.add((User)subject);
                updateJson();
                return true;
            }
        }
        else if (subject.getClass().equals(Artist.class)){
            if(artists.contains((Artist)subject)){
                return false;
            }
            else{
                artists.add((Artist)subject);
                updateJson();
                return true;
            }
        }
        return false;
    }

    public List<User> getUserList() {
        return users;
    }
    public List<Artist> getArtistList() {
        return artists;
    }
}