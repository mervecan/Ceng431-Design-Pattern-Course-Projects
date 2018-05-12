import org.apache.commons.io.FilenameUtils;
import org.json.JSONException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class XML implements FileType{
	
	private File file;
	
	public XML(String filePath) {
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
	public String toCSV() throws IOException{
        Random random = new Random();
        float possibility = random.nextFloat();

        String fileName = FilenameUtils.removeExtension(file.getAbsolutePath()) + ".csv";
        File output = new File(fileName);

        if(possibility < 0.7) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                Source source = new DOMSource(document);
                Result outputTarget = new StreamResult(output);
                transformer.transform(source, outputTarget);
            } catch (Exception e) {
                e.printStackTrace();
            }

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

        if(possibility < 0.7) {
            String xml = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            try {
                String json = org.json.XML.toJSONObject(xml).toString();
                FileWriter fileWriter = new FileWriter(output,false);
                fileWriter.write(json);
                fileWriter.close();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return fileName;
        }
		return null;
	}

	@Override
	public String toXML() throws IOException{
		return file.getAbsolutePath();
	}

	@Override
	public String toYAML() throws IOException{
		// TODO Auto-generated method stub
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
