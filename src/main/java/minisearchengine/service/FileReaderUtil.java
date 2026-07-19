package minisearchengine.service;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtil {

    public static void readFiles(String folderPath) throws IOException {

        File folder = new File(folderPath);

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Folder not found!");
            return;
        }

        for (File file : files) {

            System.out.println("\nReading : " + file.getName());

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                
                line = line.toLowerCase();
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "");
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        System.out.println(word);
                    }
                }
            }

            reader.close();

            System.out.println("--------------------------------");
        }
    }
}
