import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO add edit function
public class JsonHandler<T extends ISubject> {
    private File file;
    private ObjectMapper mapper;
    private List<T> objectList;
    private Class<T> tClass;

    public JsonHandler(String filePath, Class<T> tClass) throws IOException {
        this.file = new File(filePath);
        this.objectList = new ArrayList<>();
        this.mapper = new ObjectMapper();
        this.tClass = tClass;
    }

    public void readJson() throws IOException {
        this.objectList = this.mapper.readValue(this.file, this.mapper.getTypeFactory().constructCollectionType(ArrayList.class, this.tClass));
    }

    public void updateJson() throws IOException{
        this.mapper.writeValue(file, objectList);
    }

    public List<T> getObjectList() {
        return objectList;
    }
    
    public boolean removeObject(T object) throws IOException{
    	if(objectList.contains(object)) {
    		objectList.remove(object);
    		return true;
    	}
    	return false;
    }

    public boolean addObject(T object) throws IOException{
        //TODO: Modify so that if object exists it modifies it.
        objectList.add(object);
        return true;
    }

    public static void main(String[] args) throws IOException {

    }
}