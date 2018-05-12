import java.io.File;
import java.io.IOException;

public interface FileType {
	String toCSV() throws IOException;
	String toJSON() throws IOException;
	String toXML() throws IOException;
	String toYAML() throws IOException;
	File getFile() throws IOException;

}
