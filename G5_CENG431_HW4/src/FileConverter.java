import java.io.IOException;
import java.util.Date;

public class FileConverter implements IFileConverter {
    private static final FileConverter instance = new FileConverter();

    public static FileConverter getInstance(){
        return instance;
    }

    @Override
	public FileType convert(FileType file, EFileType newType) throws IOException {
		String newFilePath;
        LogManager logManager = LogManager.getInstance();
        String date = new Date(System.currentTimeMillis()).toString();
        String operation = "";
        String status = "FAILED";

        switch (newType) {
		case CSV:
            newFilePath  = file.toCSV();
            operation = file.getClass().getName() + " -> CSV";
            if(newFilePath != null) {
                status = "SUCCESSFUL";
                logManager.addLog(new LogElement(date, operation, status));
                return new CSV(newFilePath);
            }
            logManager.addLog(new LogElement(date, operation, status));
            return null;
		case JSON:
            newFilePath = file.toJSON();
            operation = file.getClass().getName() + " -> JSON";
            if(newFilePath != null) {
                status = "SUCCESSFUL";
                logManager.addLog(new LogElement(date, operation, status));
                return new JSON(newFilePath);
            }
            logManager.addLog(new LogElement(date, operation, status));
            return null;

        case XML:
            newFilePath = file.toXML();
            operation = file.getClass().getName() + " -> XML";
            if(newFilePath != null) {
                status = "SUCCESSFUL";
                logManager.addLog(new LogElement(date, operation, status));
                return new XML(newFilePath);
            }
            logManager.addLog(new LogElement(date, operation, status));
            return null;

        case YAML:
            newFilePath = file.toYAML();
            operation = file.getClass().getName() + " -> YAML";
            if(newFilePath != null) {
                status = "SUCCESSFUL";
                logManager.addLog(new LogElement(date, operation, status));
                return new YAML(newFilePath);
            }
            logManager.addLog(new LogElement(date, operation, status));
            return null;

        default:
            operation = file.getClass().getName() + " -> Unknown file type";
            logManager.addLog(new LogElement(date, operation, status));
            return null;
		}
	}
}
