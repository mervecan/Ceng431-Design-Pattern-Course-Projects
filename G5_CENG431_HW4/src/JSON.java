import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON implements FileType {
	
	private File file;
	
	public JSON(String filePath) {
		file = new File(filePath);
	}

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toCSV() throws IOException{
		Random random = new Random();
		float possibility = random.nextFloat();
		String fileName = "";
		if(possibility < 0.7) {
			String jsonArrayString = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			
	        JSONArray output;
	       
	            try {
					output = new JSONArray(jsonArrayString);
					 JSONArray docs = output;
					 
					 	fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".csv";
				        File outputFile = new File(fileName);
			            String csv = CDL.toString(docs);
			            FileUtils.writeStringToFile(outputFile, csv);
			            
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     
			return fileName;
		}	
        return null;
	}

	@Override
	public String toJSON() throws IOException{
		return file.getAbsolutePath();
	}

	@Override
	public String toXML() throws IOException {
		Random random = new Random();
		float possibility = random.nextFloat();
		String fileName = "";
		if (possibility < 0.7) {
			try {
				String jsonArrayString = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
				JSONArray json = new JSONArray(jsonArrayString);
				String xml = org.json.XML.toString(json);
				fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".xml";
		        File output = new File(fileName);
		        FileWriter fileWriter = new FileWriter(output,false);
		        fileWriter.write(xml);
		        fileWriter.close();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fileName;
		}
		return null;
	}

	@Override
	public String toYAML() throws IOException {
		Random random = new Random();
		float possibility = random.nextFloat();

		if (possibility < 0.7) {

			String jsonArrayString = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			// parse JSON
			JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonArrayString);
			// save it as YAML
//			String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
			String fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".yaml";
			File output = new File(fileName);
			FileWriter fileWriter = new FileWriter(output, false);
			fileWriter.write("TODO");
			fileWriter.close();

			return fileName;
		}
		return null;
	}

}