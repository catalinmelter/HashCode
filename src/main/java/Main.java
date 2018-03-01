import static services.FileInfoService.getFileInfo;
import static services.FileParserService.getFileParser;
import static services.FileOutputService.getFileOutputService;

public class Main {
    private static final String INPUT_FILE_NAME = "FileIn\\example.in";
    private static final String OUTPUT_FILE_NAME = "FileOut\\output_" + INPUT_FILE_NAME;

    public static void main(String[] args) {
        getFileParser().parseFile(INPUT_FILE_NAME);
        getFileInfo().logic();
        getFileOutputService().fileOutputWrite(OUTPUT_FILE_NAME);
        getFileOutputService().FileOutputValidation(OUTPUT_FILE_NAME);
    }
}
