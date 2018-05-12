import org.apache.commons.io.FilenameUtils;

public class FileFactory {
    private static final FileFactory instance = new FileFactory();

    private FileFactory(){}
    public static FileFactory getInstance(){
        return instance;
    }

    public FileType createFile(String filePath) {
        if (FilenameUtils.getExtension(filePath).equals(EFileType.CSV.name().toLowerCase())) {
            return new CSV(filePath);
        } else if (FilenameUtils.getExtension(filePath).equals(EFileType.JSON.name().toLowerCase())) {
            return new JSON(filePath);
        } else if (FilenameUtils.getExtension(filePath).equals(EFileType.XML.name().toLowerCase())) {
            return new XML(filePath);
        } else if (FilenameUtils.getExtension(filePath).equals(EFileType.YAML.name().toLowerCase())) {
            return new YAML(filePath);
        } else
            return null;
    }
}
