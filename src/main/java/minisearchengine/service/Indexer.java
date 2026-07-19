package minisearchengine.service;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Indexer {

    private HashMap<String, HashSet<String>> index;
    private HashSet<String> stopWords;

    public Indexer() {
        index = new HashMap<>();
        stopWords = new HashSet<>(Arrays.asList(
            "is", "the", "a", "an", "and", "or",
            "to", "of", "in", "for", "on", "with"
        ));
    }

    public void addWord(String word, String fileName) {

        index.putIfAbsent(word, new HashSet<>());

        index.get(word).add(fileName);

    }
    public void buildIndex(String folderPath) throws IOException {

    File folder = new File(folderPath);

    File[] files = folder.listFiles();

    if (files == null) {
        System.out.println("Folder not found!");
        return;
    }

    for (File file : files) {

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        while ((line = reader.readLine()) != null) {

            line = line.toLowerCase();

            line = line.replaceAll("[^a-zA-Z0-9\\s]", "");

            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty() && !stopWords.contains(word)) {
                    addWord(word, file.getName());
                }
            }

        }

        reader.close();
    }
}
    public void printIndex() {

    for (String word : index.keySet()) {
        System.out.println(word + " -> " + index.get(word));
    }
}
    public HashMap<String, HashSet<String>> getIndex() {
    return index;
}

}