import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		FileConverter fileConverter = FileConverter.getInstance();
		FileFactory fileFactory = FileFactory.getInstance();
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path of the file you want to convert, to exit enter Q:");
            String filePath = scanner.next();
            if(filePath.toLowerCase().equals("q"))
                break;
            FileType newFile = fileFactory.createFile(filePath);
            if(newFile == null)
                continue;
            System.out.println("Enter the extention you want to convert to:");
            String choice = scanner.next().toUpperCase();
            FileType convertedFile = fileConverter.convert(newFile, EFileType.valueOf(choice));
            System.out.println(getConversionInfo());
        }
    }


	// The list returned can be used to analyse to achieve the analyses mentioned in the assignment text
	public static HashMap<String, String> getConversionInfo(){
	    HashMap<String, String> conversionInfo = new HashMap<>();
        List<LogElement> logs = LogManager.getInstance().getLogs();
	    for(LogElement logElement: logs) {
            String from = logElement.getOperation().split("->")[0];
            String to = logElement.getOperation().split("->")[1];
            conversionInfo.put(from, to);
        }
        return conversionInfo;
    }
}
