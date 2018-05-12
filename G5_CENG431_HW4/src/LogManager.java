import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogManager {
    private File logFile;
    private static final LogManager instance = new LogManager("log.json");
    private ObjectMapper mapper;
    private List<LogElement> logs;

    private LogManager(String filePath){
        logs = new ArrayList<LogElement>();
        logFile = new File(filePath);
        this.mapper = new ObjectMapper();
        if(logFile.exists())
            readLog();
    }

    public static LogManager getInstance(){
        return instance;
    }

    public void readLog() {
        try {
            this.logs = this.mapper.readValue(this.logFile, new TypeReference<List<LogElement>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateLog(){
        try {
            this.mapper.writeValue(logFile, logs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLog(LogElement logElement){
        logs.add(logElement);
        System.out.println(logElement.toString());
        updateLog();
    }

    public File getLogFile() {
        return logFile;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public List<LogElement> getLogs() {
        return logs;
    }

    public void setLogs(List<LogElement> logs) {
        this.logs = logs;
    }
}
