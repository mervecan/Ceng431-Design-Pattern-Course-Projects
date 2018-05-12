import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class YAML implements FileType{
	
	private File file;
	
	public YAML(String filePath) {
		file = new File(filePath);
	}

	@Override
	public File getFile() {
		
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toCSV() throws IOException {
		Random random = new Random();
		float possibility = random.nextFloat();

		String fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".csv";
		File output = new File(fileName);

		if (possibility < 0.7) {

            FileWriter fileWriter = new FileWriter(output, false);
            fileWriter.write("FROM_CSV");
            fileWriter.close();
			return fileName;
		}
		return null;
	}

	@Override
	public String toJSON() throws IOException{
        Random random = new Random();
        float possibility = random.nextFloat();

        String fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".json";
        File output = new File(fileName);

        if (possibility < 0.7) {
            String yaml = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(yaml, Object.class);

            ObjectMapper jsonWriter = new ObjectMapper();
            jsonWriter.writerWithDefaultPrettyPrinter().writeValue(output, obj);
            return fileName;
        }
        return null;
	}

	@Override
	public String toXML() throws IOException{
        Random random = new Random();
        float possibility = random.nextFloat();

        String fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".xml";
        File output = new File(fileName);

        if (possibility < 0.7) {
            FileWriter fileWriter = new FileWriter(output, false);
            fileWriter.write("FROM_XML");
            fileWriter.close();
            return fileName;
        }
        return null;

    }

	@Override
	public String toYAML() throws IOException{
        return file.getAbsolutePath();
    }

}
