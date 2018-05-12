import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import com.thoughtworks.xstream.XStream;

import au.com.bytecode.opencsv.CSVReader;


public class CSV implements FileType{
	
	private File file;
	
	
	public CSV(String filePath) {
		file = new File(filePath);
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public File getFile() {
		return file;
	}
	
	@Override
	public String toCSV() throws IOException{
		return file.getAbsolutePath();
	}

	@Override
	public String toJSON() throws IOException {
		
		Random random = new Random();
		float possibility = random.nextFloat();
		
		if(possibility < 0.7) {
			CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
	        CsvMapper csvMapper = new CsvMapper();
	 
	        // Read data from CSV file
	        List<Object> readAll = csvMapper.reader(Map.class).with(csvSchema).readValues(file).readAll(); 
	        ObjectMapper mapper = new ObjectMapper();
	        String fileName = FilenameUtils.removeExtension(file.getAbsolutePath())+ ".json";
	        File output = new File(fileName);
	        // Write JSON formated data to output.json file
	        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
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
		
		if(possibility < 0.7) {
			CSVReader reader = new CSVReader(new FileReader(file));
            String[] line = null;

            String[] header = reader.readNext();

            List<Object> out = new ArrayList<Object>();

            while((line = reader.readNext())!=null){
                List<String[]> item = new ArrayList<String[]>();
                    for (int i = 0; i < header.length; i++) {
                    String[] keyVal = new String[2];
                    String string = header[i];
                    String val = line[i];
                    keyVal[0] = string;
                    keyVal[1] = val;
                    item.add(keyVal);
                }
                out.addAll(item);
            }

            XStream xstream = new XStream();

            xstream.toXML(out, new FileWriter(output,false));
            reader.close();
			return fileName;
		}	
        return null;
	}

	@Override
	public String toYAML() throws IOException{
		Random random = new Random();
		float possibility = random.nextFloat();

		String fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".yaml";
		File output = new File(fileName);

		if(possibility < 0.7) {

			return fileName;
		}
		return null;
	}

}
