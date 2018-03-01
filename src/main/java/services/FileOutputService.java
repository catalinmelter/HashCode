package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOutputService {
    private FileOutputService() {}
    private static class SingletonHolder {
        static final FileOutputService SINGLETON = new FileOutputService();
    }
    public static FileOutputService getFileOutputService(){
        return SingletonHolder.SINGLETON;
    }

    public void fileOutputWrite(String fileOutputName){
        StringBuilder content = new StringBuilder();

        content.append("\n");

        try {
            Files.write(Paths.get(fileOutputName), content.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void FileOutputValidation(String fileOutputName) {
        String line;
        String[] splited;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileOutputName)))) {
            // First Line
            line = br.readLine();
            splited = line.split("\\s+");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
