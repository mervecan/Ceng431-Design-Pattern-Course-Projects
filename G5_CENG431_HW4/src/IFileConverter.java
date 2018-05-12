import java.io.IOException;

public interface IFileConverter {
	
	FileType convert(FileType file, EFileType newType) throws IOException;
	
	
	
}
