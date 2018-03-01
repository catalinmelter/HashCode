package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileParserService {
    private FileParserService() {}
    private static class SingletonHolder {
        static final FileParserService SINGLETON = new FileParserService();
    }
    public static FileParserService getFileParser(){
        return SingletonHolder.SINGLETON;
    }

    public void parseFile(String fileName) {
        String line;
        String[] splited;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            // First Line
            line = br.readLine();
            splited = line.split("\\s+");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
