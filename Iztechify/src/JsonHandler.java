import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler<T> {
    private File file;
    private ObjectMapper mapper;
    private List<T> objectList;

    public JsonHandler(String filePath) throws IOException {
        this.file = new File(filePath);
        this.objectList = new ArrayList<>();
        this.mapper = new ObjectMapper();
    }

    public void readJson(Class<T> tClass) throws IOException {
        this.objectList = this.mapper.readValue(this.file, this.mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass));
    }

    public void updateJson() throws IOException{
        this.mapper.writeValue(file, objectList);
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public static void main(String[] args) throws IOException {
        JsonHandler<Artist> jsonHandler = new JsonHandler<>("music.json");
        jsonHandler.readJson(Artist.class);
        for(Artist artist: jsonHandler.getObjectList()){
            System.out.println(artist.getName());
        }
    }
}
