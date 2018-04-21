import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO add edit function
public class JsonHandler<T extends ISubject> {
    private File file;
    private ObjectMapper mapper;
    private List<T> objectList;
    private Class<T> tClass;
    private Set<String> fields;

    public JsonHandler(String filePath, Class<T> tClass) throws IOException {
        this.file = new File(filePath);
        this.objectList = new ArrayList<>();
        this.mapper = new ObjectMapper();
        this.tClass = tClass;
        fields = new HashSet<String>();
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
   
    public Set<String> getFields() {
		return fields;
	}

	public void setFields(Set<String> fields) {
		this.fields = fields;
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
}